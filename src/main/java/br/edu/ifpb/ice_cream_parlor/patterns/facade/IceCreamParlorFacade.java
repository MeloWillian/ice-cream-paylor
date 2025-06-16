package br.edu.ifpb.ice_cream_parlor.patterns.facade;

import br.edu.ifpb.ice_cream_parlor.model.entities.*;
import br.edu.ifpb.ice_cream_parlor.model.entities.enums.IceCreamType;
import br.edu.ifpb.ice_cream_parlor.model.view.OrderView;
import br.edu.ifpb.ice_cream_parlor.patterns.command.main_menu.ShowCatalogMenuCommand;
import br.edu.ifpb.ice_cream_parlor.patterns.decorator.IceCream;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.IceCreamFactory;
import br.edu.ifpb.ice_cream_parlor.patterns.observer.ClientNotification;
import br.edu.ifpb.ice_cream_parlor.patterns.observer.OrderStatusNotifier;
import br.edu.ifpb.ice_cream_parlor.patterns.repository.ClientRepository;
import br.edu.ifpb.ice_cream_parlor.patterns.repository.OrderRepository;
import br.edu.ifpb.ice_cream_parlor.patterns.singleton.OrderQueue;
import br.edu.ifpb.ice_cream_parlor.patterns.strategy.Coupon;

import java.util.*;

import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.*;

public class IceCreamParlorFacade {

    private final Map<String, Client> clients = new HashMap<>();
    private final Map<String, Order> orders = new HashMap<>();
    private final OrderStatusNotifier notifier = new OrderStatusNotifier();
    private final OrderQueue queue = OrderQueue.getInstance();
    private final OrderRepository orderRepository = new OrderRepository();
    private final ClientRepository clientRepository = new ClientRepository();
    private final ShowCatalogMenuCommand showCatalogMenuCommand = new ShowCatalogMenuCommand();
    private Scanner sc = new Scanner(System.in);

    // Cadastra cliente e inscreve observador
    public void registerClient(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode estar vazio.");
        }

        if (name.length() < 3) {
            throw new IllegalArgumentException("O nome do cliente não pode ter menos de três caracteres.");
        }

        Client client = new Client(name);
        clients.put(client.getId(), client);
        notifier.addObserver(new ClientNotification(name));
    }

    // Cria pedido e o vincula a um cliente
    private String createEmptyOrder(String clientName) {
        Client client = clients.values().stream()
                .filter(c -> c.getName().equalsIgnoreCase(clientName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));

        Order order = new Order(notifier);
        orders.put(order.getId(), order);
        queue.addOrder(order);
        System.out.println("🧾 Pedido criado para: " + client.getName() + " | ID: " + order.getId());
        return order.getId();
    }

    public void cancelOrder(String orderId) {
        Order order = orders.remove(orderId);

        if (order != null) {
            queue.removeOrder(order);
            notifier.notifyObservers(orderId, "Cancelado");
            System.out.println("❌ Pedido cancelado com sucesso: " + orderId);
        } else {
            System.out.println("⚠️ Pedido não encontrado para cancelamento.");
        }
    }

    // Adiciona sorvete ao pedido
    private void addItemToOrder(String orderId, IceCreamType type, String flavor, int scoops, String size, int quantity) {
        Order order = getOrderById(orderId);
        IceCream iceCream = IceCreamFactory.createIceCream(type, flavor, scoops, size);
        order.addItem(iceCream, quantity);
        System.out.println("🍨 Item adicionado: " + iceCream.getName() + " x" + quantity);
    }

    // Aplica cupom de desconto
    private void applyCouponToOrder(String orderId, Coupon coupon) {
        Order order = getOrderById(orderId);
        order.setCoupon(coupon);
        double discountedPrice = coupon.applyDiscount(order.getTotal());
//        order.setFinalPrice(discountedPrice);
        System.out.println("💸 Cupom aplicado! Preço com desconto: $" + String.format("%.2f", discountedPrice));
    }

    // Processa próximo pedido na fila e avança seu estado
    public void processNextOrder() {
        try {
            Order order = queue.processNextOrder();
            System.out.println(order);
            order.nextState();
        } catch (Exception e) {
            System.out.println("⚠️ " + e.getMessage());
        }
    }

    // Avança manualmente o estado de um pedido
    public void advanceOrderState(String orderId) {
        Order order = getOrderById(orderId);
        order.nextState();
    }

    // Visualiza detalhes do pedido
    public void printOrderDetails(String orderId) {
        Order order = getOrderById(orderId);
        System.out.println(order);
    }

    private Order getOrderById(String orderId) {
        Order order = orders.get(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Pedido não encontrado: " + orderId);
        }
        return order;
    }

    public Order createOrder() {

        try {
            System.out.println("Insira o nome do cliente");
            String name = sc.next();
            List<Client> clientList = clientRepository.findAll();

            if(clientList.isEmpty()) {
                throw new Exception("Cliente não cadastrado");
            }

            String orderId = createEmptyOrder(name);

            System.out.println("Escolha o tipo de sorvete" +
                    "1. Picolé" +
                    "2. Massa" +
                    "3. Milkshake");

            String type = sc.next();

            while(!Arrays.asList("1", "2", "3").contains(type)) {
                System.out.println("Selecione uma opção válida!");
                type = sc.next();
            }

            IceCreamType iceCreamType = (type.equals("1")) ? IceCreamType.POPSICLE
                    : (type.equals("2")) ? IceCreamType.SCOOPED
                    : IceCreamType.MILKSHAKE;

            System.out.println("Selecione o sabor do sorvete");

            for(int i = 1; i <= iceCreamType.getFlavors().size(); i++) {
                System.out.println(i + "." + iceCreamType.getFlavors().get(i));
            }

            int flavorNumber = sc.nextInt();

            while(!Arrays.asList(1, 2).contains(flavorNumber)) {
                System.out.println("Selecione uma opção válida!");
                type = sc.next();
            }

            String flavor = iceCreamType.getFlavors().get(flavorNumber);

            int balls = 0;
            if(iceCreamType.equals(IceCreamType.SCOOPED)) {
                System.out.println("Selecione a quantidade de bolas");
                balls = sc.nextInt();
            }

            String size = "";
            if(iceCreamType.equals(IceCreamType.MILKSHAKE)) {
                System.out.println("Selecione o tamanho" +
                        "P - Pequeno" +
                        "M - Médio" +
                        "G - Grande");

                size = sc.next();
                while(!Arrays.asList("P", "M", "G").contains(type)) {
                    System.out.println("Selecione uma opção válida!");
                    size = sc.next();
                }
            }

            System.out.println("Quantas unidades deste item você deseja?");
            int quantity = sc.nextInt();

            addItemToOrder(orderId, iceCreamType, flavor, balls, size, quantity);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    public void displayHistoryOrders() {
        List<OrderView> orderViewList = orderRepository.findAllOrders();

        if(orderViewList.isEmpty()) {
            System.out.println("\n" + RED_BOLD + "=== 📋 Sem pedidos registrados ===" + RESET);
        } else {
            System.out.println("\n" + GREEN_BOLD + "=== 📋 Histórico de pedidos ===" + RESET);
            for(OrderView ov : orderViewList) {
                System.out.println(ov);
            }
        }
    }
}
