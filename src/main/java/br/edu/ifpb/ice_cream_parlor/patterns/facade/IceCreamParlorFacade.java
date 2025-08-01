package br.edu.ifpb.ice_cream_parlor.patterns.facade;

import br.edu.ifpb.ice_cream_parlor.model.entities.*;
import br.edu.ifpb.ice_cream_parlor.model.entities.enums.IceCreamType;
import br.edu.ifpb.ice_cream_parlor.model.view.OrderView;
import br.edu.ifpb.ice_cream_parlor.patterns.decorator.*;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.CouponFactory;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.IceCreamFactory;
import br.edu.ifpb.ice_cream_parlor.patterns.observer.*;
import br.edu.ifpb.ice_cream_parlor.patterns.repository.ClientRepository;
import br.edu.ifpb.ice_cream_parlor.patterns.repository.OrderRepository;
import br.edu.ifpb.ice_cream_parlor.patterns.singleton.OrderQueue;
import br.edu.ifpb.ice_cream_parlor.patterns.strategy.Coupon;

import java.util.*;

import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.*;

public class IceCreamParlorFacade {

    private static IceCreamParlorFacade instance;
    private final Map<String, Order> orders = new HashMap<>();
    private final OrderStatusNotifier notifier = new OrderStatusNotifier();
    private final OrderQueue queue = OrderQueue.getInstance();
    private final OrderRepository orderRepository = new OrderRepository();
    private final ClientRepository clientRepository = new ClientRepository();
    private final Scanner sc = new Scanner(System.in);
    OrderQueue orderQueue = OrderQueue.getInstance();

    private String lastCreatedOrderId;
    private IceCreamParlorFacade() {}

    public static IceCreamParlorFacade getInstance() {
        if (instance == null) {
            instance = new IceCreamParlorFacade();
        }
        return instance;
    }

    // --- CLIENTES ---

    public void registerClient(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 3) {
            throw new IllegalArgumentException("Nome inválido para cliente.");
        }

        Client client = new Client(name);
        clientRepository.save(client);
    }

    public void listClients() {
        List<Client> clients = clientRepository.findAll();
        if (clients.isEmpty()) {
            System.out.println("🙁 Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("\n=== 👥 Clientes Cadastrados ===");
        System.out.printf("%-5s | %-30s | %-40s\n", "ID", "Nome", "UUID");
        System.out.println("--------------------------------------------------------------------------");

        int i = 1;
        for (Client client : clients) {
            System.out.printf("%-5d | %-30s | %-40s\n", i++, client.getName(), client.getId());
        }
    }

    // --- PEDIDOS ---

    public void startOrder(String clientName) throws Exception {
        Client client = clientRepository.findByName(clientName);
        if (client == null) throw new Exception("Cliente não encontrado.");

        Order order = new Order(notifier);
        order.setClient(client);
        orders.put(order.getId(), order);
        queue.addOrder(order);
        lastCreatedOrderId = order.getId();

        notifier.addObserver(order.getId(), new ClientNotification(client.getName()));

        System.out.println("🧾 Pedido iniciado para " + client.getName() + " | ID: " + order.getId());
    }

    public boolean hasCurrentOrder() {
        return lastCreatedOrderId != null && orders.containsKey(lastCreatedOrderId);
    }

    public void addItemToCurrentOrder() {
        Order order = orders.get(lastCreatedOrderId);
        if (order == null) {
            System.out.println("⚠️ Nenhum pedido em andamento.");
            return;
        }

        try {
            System.out.println("Escolha o tipo de sorvete:\n1. Picolé\n2. Massa\n3. Milkshake");
            String typeInput = sc.next();

            while (!Arrays.asList("1", "2", "3").contains(typeInput)) {
                System.out.println("Opção inválida. Tente novamente:");
                typeInput = sc.next();
            }

            IceCreamType type = switch (typeInput) {
                case "1" -> IceCreamType.POPSICLE;
                case "2" -> IceCreamType.SCOOPED;
                case "3" -> IceCreamType.MILKSHAKE;
                default -> throw new IllegalArgumentException("Tipo inválido");
            };

            List<String> flavors = type.getFlavors();
            for (int i = 0; i < flavors.size(); i++) {
                System.out.println((i + 1) + ". " + flavors.get(i));
            }

            int flavorNumber = sc.nextInt();
            while (flavorNumber < 1 || flavorNumber > flavors.size()) {
                System.out.println("Opção inválida. Escolha novamente:");
                flavorNumber = sc.nextInt();
            }

            String flavor = flavors.get(flavorNumber - 1);
            int scoops = 0;
            if (type == IceCreamType.SCOOPED) {
                System.out.println("Quantas bolas?");
                scoops = sc.nextInt();
            }

            String size = "";
            if (type == IceCreamType.MILKSHAKE) {
                System.out.println("Tamanho (P/M/G):");
                size = sc.next().toUpperCase();
                while (!Arrays.asList("P", "M", "G").contains(size)) {
                    System.out.println("Tamanho inválido. Escolha P, M ou G:");
                    size = sc.next().toUpperCase();
                }
            }

            IceCream iceCream = IceCreamFactory.createIceCream(type, flavor, scoops, size);

            boolean addingAdditions = true;
            while (addingAdditions) {
                System.out.println("Deseja adicionar algum adicional? (S/N)");
                String add = sc.next();
                if (!add.equalsIgnoreCase("S")) break;

                System.out.println("1. Chantilly\n2. Calda de Caramelo\n3. Chocolate\n4. Cancelar adicionais");
                String extra = sc.next();

                switch (extra) {
                    case "1" -> {
                        iceCream = new WhippedCream(iceCream);
                        System.out.println("Adicionado: Chantilly");
                    }
                    case "2" -> {
                        iceCream = new CaramelSauce(iceCream);
                        System.out.println("Adicionado: Calda de Caramelo");
                    }
                    case "3" -> {
                        iceCream = new ChocolateTopping(iceCream);
                        System.out.println("Adicionado: Chocolate");
                    }
                    case "4" -> addingAdditions = false;
                    default -> System.out.println("Opção inválida.");
                }
            }

            System.out.println("Quantidade:");
            int quantity = sc.nextInt();

            order.addItem(iceCream, quantity);
            System.out.println("🍨 Item adicionado: " + iceCream.getName() + " x" + quantity);

        } catch (Exception e) {
            System.out.println("❌ Erro ao adicionar item: " + e.getMessage());
        }
    }

    public void viewCurrentOrder() {
        if (!hasCurrentOrder()) {
            System.out.println("⚠️ Nenhum pedido criado até o momento.");
            return;
        }

        Order order = orders.get(lastCreatedOrderId);
        System.out.println("\n" + CYAN + "=== Pedido Atual ===" + RESET);
        System.out.println(order);
    }

    public void confirmOrder() {
        if (!hasCurrentOrder()) {
            System.out.println("⚠️ Nenhum pedido para confirmar.");
            return;
        }

        Order order = orders.get(lastCreatedOrderId);
        System.out.println("\nResumo do pedido:");
        System.out.println(order);

        System.out.println("Confirmar pedido? (S/N)");
        String confirm = sc.next();
        if (confirm.equalsIgnoreCase("S")) {
            orderRepository.save(order);
            notifier.notifyObservers(order.getId(), "Confirmado");
            System.out.println("✅ Pedido confirmado!");
            lastCreatedOrderId = null;
            orderQueue.addOrder(order);
        } else {
            System.out.println("❌ Pedido não confirmado.");
        }
    }

    public void cancelOrder() {
        if (!hasCurrentOrder()) {
            System.out.println("⚠️ Nenhum pedido para cancelar.");
            return;
        }

        Order order = orders.remove(lastCreatedOrderId);
        if (order != null) {
            queue.removeOrder(order);
            notifier.notifyObservers(order.getId(), "Cancelado");
            notifier.removeObservers(order.getId()); // 🔥 Remove observers desse pedido
            System.out.println("❌ Pedido cancelado.");
        } else {
            System.out.println("⚠️ Pedido não encontrado.");
        }

        lastCreatedOrderId = null;
    }
    public void applyCoupon() {
        if (!hasCurrentOrder()) {
            System.out.println("⚠️ Nenhum pedido para aplicar desconto.");
            return;
        }

        System.out.println("📦 Cupons disponíveis:");
        CouponFactory.getAvailableCoupons().forEach((code, name) ->
                System.out.println("- " + name + " (Código: " + code + ")"));

        System.out.print("Digite o código do cupom: ");
        String code = sc.next();

        try {
            Coupon coupon = CouponFactory.createCoupon(code.toUpperCase());
            Order order = orders.get(lastCreatedOrderId);
            order.setCoupon(coupon);
            System.out.println("💸 Cupom aplicado com sucesso!");
            viewCurrentOrder();
        } catch (Exception e) {
            System.out.println("⚠️ " + e.getMessage());
        }
    }

    // --- HISTÓRICO E FILA ---

    public void displayHistoryOrders() {
        List<OrderView> views = orderRepository.findAllOrders();

        if (views.isEmpty()) {
            System.out.println(RED_BOLD + "\n📋 Sem pedidos registrados." + RESET);
        } else {
            System.out.println(GREEN_BOLD + "\n=== Histórico de Pedidos ===" + RESET);
            views.forEach(System.out::println);
        }
    }

    public void processNextOrder() {
        try {
            Order order = queue.processNextOrder();
            order.nextState();
            System.out.println(order);
        } catch (Exception e) {
            System.out.println("⚠️ " + e.getMessage());
        }
    }

    public void advanceOrderState(String orderId) {
        Order order = orders.get(orderId);
        if (order != null) order.nextState();
    }

    public void showCurrentOrder() {
        Order order = getCurrentOrder();

        if (order == null) {
            System.out.println("⚠️ Nenhum pedido na fila.");
            return;
        }

        System.out.println(order);

        if (order.getStatus().equals("Cancelado")) {
            notifier.removeObservers(order.getId());
            orderQueue.processNextOrder();

            Order nextOrder = getCurrentOrder();
            if (nextOrder != null) {
                System.out.println("\n" + GREEN_BOLD + "➡️ Próximo pedido na fila:" + RESET);
                System.out.println(nextOrder);
            } else {
                System.out.println("\n" + RED_BOLD + "❌ A FILA DE PEDIDOS ESTÁ VAZIA!" + RESET);
            }
        }
    }


    public Order getCurrentOrder(){
        return orderQueue.peek();
    }

    public void updateStatus() {
        Order order = getCurrentOrder();
        if (order == null) {
            System.out.println("⚠️ Nenhum pedido na fila.");
            return;
        }

        order.nextState();
        notifier.notifyObservers(order.getId(), order.getStatus());

        if (order.getStatus().equals("Finalizado")) {
            notifier.removeObservers(order.getId());
            if (!orderQueue.isEmpty()) {
                orderQueue.processNextOrder();
            }
        }

        if (orderQueue.isEmpty()) {
            System.out.println("\n" + RED_BOLD + " ❌ A FILA DE PEDIDOS ESTÁ VAZIA!" + RESET);
        }
    }

    public void cancelStatus() {
        Order order = getCurrentOrder();
        if (order == null) {
            System.out.println("⚠️ Nenhum pedido na fila.");
            return;
        }

        order.cancelState();
        notifier.removeObservers(order.getId());
        if(!orderQueue.isEmpty()){orderQueue.processNextOrder();}
    }

}
