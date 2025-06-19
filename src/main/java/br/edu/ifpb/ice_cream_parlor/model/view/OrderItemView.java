package br.edu.ifpb.ice_cream_parlor.model.view;

public class OrderItemView {
    private String iceCream;
    private int quantity;
    private double subtotal;

    public String getIceCream() {
        return iceCream;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setIceCream(String iceCream) {
        this.iceCream = iceCream;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
