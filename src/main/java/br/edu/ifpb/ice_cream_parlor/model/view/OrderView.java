package br.edu.ifpb.ice_cream_parlor.model.view;

import java.time.LocalDate;
import java.util.List;

public class OrderView {
    private String id;
    private List<OrderItemView> items;
    private LocalDate date;
    private String status;
    private String coupon;
    private String client;
    private double subtotal;
    private double total;

    public String getId() {
        return id;
    }

    public List<OrderItemView> getItems() {
        return items;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getClient() {
        return client;
    }

    public String getCoupon() {
        return coupon;
    }

    public double getTotal() {
        return total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setItems(List<OrderItemView> items) {
        this.items = items;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("+--------------------------------------------------+\n");
        sb.append("| Pedido ID     : ").append(id).append("\n");
        sb.append("| Cliente       : ").append(client).append("\n");
        sb.append("| Data          : ").append(date).append("\n");
        sb.append("| Status        : ").append(status).append("\n");
        sb.append("| Cupom         : ").append(coupon != null ? coupon : "-").append("\n");
        sb.append("| Subtotal      : R$ ").append(String.format("%.2f", subtotal)).append("\n");
        sb.append("| Total         : R$ ").append(String.format("%.2f", total)).append("\n");
        sb.append("+-------------------- ITENS DO PEDIDO -------------+\n");
        sb.append(String.format("| %-25s | %5s | %10s |\n", "Sorvete", "Qtd", "Subtotal"));
        sb.append("|---------------------------|-------|------------|\n");

        if (items != null && !items.isEmpty()) {
            for (OrderItemView item : items) {
                sb.append(String.format("| %-25s | %5d | R$ %8.2f |\n",
                        item.getIceCream(),
                        item.getQuantity(),
                        item.getSubtotal()));
            }
        } else {
            sb.append("| (Sem itens)                                |\n");
        }

        sb.append("+--------------------------------------------------+\n");
        return sb.toString();
    }

}
