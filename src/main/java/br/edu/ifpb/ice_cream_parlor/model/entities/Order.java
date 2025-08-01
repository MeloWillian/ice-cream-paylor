package br.edu.ifpb.ice_cream_parlor.model.entities;

import br.edu.ifpb.ice_cream_parlor.patterns.decorator.IceCream;
import br.edu.ifpb.ice_cream_parlor.patterns.observer.OrderStatusNotifier;
import br.edu.ifpb.ice_cream_parlor.patterns.state.NewOrder;
import br.edu.ifpb.ice_cream_parlor.patterns.state.OrderState;
import br.edu.ifpb.ice_cream_parlor.patterns.strategy.Coupon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private List<OrderItem> items;
    private LocalDate date;
    private OrderState status;
    private OrderStatusNotifier notifier;
    private Coupon coupon;
    private Client client;

    public Order(OrderStatusNotifier notifier) {
        this.id = UUID.randomUUID().toString();
        this.items = new ArrayList<>();
        this.date = LocalDate.now();
        this.status = new NewOrder();
        this.coupon = null;
        this.notifier = notifier;

        this.notifier.notifyObservers(this.id, status.getStatus());
    }

    public String getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(items);
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status.getStatus();
    }

    public void setStatus(OrderState status) {
        this.status = status;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getTotal() {
        double total = getSubTotal();
        return (coupon != null) ? total - coupon.applyDiscount(total) : total;
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    public void addItem(IceCream iceCream, int quantity) {
        this.items.add(new OrderItem(iceCream, quantity));
    }

    public double getSubTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void nextState() {
        status.next(this);
    }

    public void cancelState() {
        status.cancel(this);
        notifier.notifyObservers(this.id, status.getStatus());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido: ").append(id).append("\n");
        sb.append("Cliente: ").append(client != null ? client.getName() : "Sem cliente").append("\n");
        sb.append("Data: ").append(date).append("\n");
        sb.append("Status: ").append(status.getStatus()).append("\n\n");

        sb.append(String.format("%-4s | %-25s | %-8s | %-9s\n", "Qt", "Descrição", "Preço", "Subtotal"));
        sb.append("-----------------------------------------------------------\n");

        for (OrderItem item : items) {
            int quantity = item.getQuantity();
            String description = item.getIceCream().getDescription();
            double price = item.getIceCream().getBasePrice();
            double subtotal = item.getSubtotal();

            sb.append(String.format("%-4d | %-25s | R$ %6.2f | R$ %7.2f\n",
                    quantity, description, price, subtotal));
        }

        sb.append("-----------------------------------------------------------\n");
        sb.append(String.format("Subtotal: R$ %.2f\n", getSubTotal()));

        if (coupon != null) {
            double discount = coupon.applyDiscount(getSubTotal());
            sb.append(String.format("Desconto: R$ %.2f\n", discount));
        }

        sb.append(String.format("Total: R$ %.2f\n", getTotal()));

        return sb.toString();
    }


}
