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
        if (item != null) {
            this.items.add(item);
        }
    }

    public void addItem(IceCream iceCream, int quantity) {
        if (iceCream != null && quantity > 0) {
            this.items.add(new OrderItem(iceCream, quantity));
        }
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
        notifier.notifyObservers(this.id, status.getStatus());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(id).append("\n");
        sb.append("Items:\n");
        if (items.isEmpty()) {
            sb.append("  (No items in order)\n");
        } else {
            for (OrderItem item : items) {
                sb.append("  - ").append(item.toString()).append("\n");
            }
        }
        sb.append("Sub Total: $").append(String.format("%.2f", getSubTotal())).append("\n");
        sb.append("Total: $").append(String.format("%.2f", getTotal()));
        return sb.toString();
    }
}
