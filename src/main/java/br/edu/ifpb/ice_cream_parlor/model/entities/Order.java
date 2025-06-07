package br.edu.ifpb.ice_cream_parlor.model.entities;

import br.edu.ifpb.ice_cream_parlor.patterns.decorator.IceCream;
import br.edu.ifpb.ice_cream_parlor.patterns.strategy.Coupon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private List<OrderItem> items;
    private Client client;
    private LocalDate date;
    private String status;
    private Coupon coupon;

    public Order(Client client) {
        this.id = UUID.randomUUID().toString();
        this.items = new ArrayList<>();
        this.client = client;
        this.date = LocalDate.now();
        this.status = "";
        this.coupon = null;
    }

    public String getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(items);
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
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

    public double getTotalAmount() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total;
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
        sb.append("Total Amount: $").append(String.format("%.2f", getTotalAmount()));
        return sb.toString();
    }
}
