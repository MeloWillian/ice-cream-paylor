package br.edu.ifpb.ice_cream_parlor.patterns.facade;

import br.edu.ifpb.ice_cream_parlor.model.entities.*;
import br.edu.ifpb.ice_cream_parlor.model.entities.enums.IceCreamType;
import br.edu.ifpb.ice_cream_parlor.patterns.decorator.IceCream;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.IceCreamFactory;
import br.edu.ifpb.ice_cream_parlor.patterns.observer.ClientNotification;
import br.edu.ifpb.ice_cream_parlor.patterns.observer.OrderStatusNotifier;
import br.edu.ifpb.ice_cream_parlor.patterns.singleton.OrderQueue;
import br.edu.ifpb.ice_cream_parlor.patterns.strategy.Coupon;

import java.util.HashMap;
import java.util.Map;

public class IceCreamParlorFacade {

    private final Map<String, Client> clients = new HashMap<>();
    private final Map<String, Order> orders = new HashMap<>();
    private final OrderStatusNotifier notifier = new OrderStatusNotifier();
    private final OrderQueue queue = OrderQueue.getInstance();

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
    public String createOrder(String clientName) {
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
    public void addItemToOrder(String orderId, IceCreamType type, String flavor, int scoops, String size, int quantity) {
        Order order = getOrderById(orderId);
        IceCream iceCream = IceCreamFactory.createIceCream(type, flavor, scoops, size);
        order.addItem(iceCream, quantity);
        System.out.println("🍨 Item adicionado: " + iceCream.getName() + " x" + quantity);
    }

    // Aplica cupom de desconto
    public void applyCouponToOrder(String orderId, Coupon coupon) {
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
}
