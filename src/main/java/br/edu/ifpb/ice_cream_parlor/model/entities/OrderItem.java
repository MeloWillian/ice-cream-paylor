package br.edu.ifpb.ice_cream_parlor.model.entities;

import br.edu.ifpb.ice_cream_parlor.patterns.decorator.IceCream;

public class OrderItem {
    private IceCream iceCream;
    private int quantity;

    public OrderItem(IceCream iceCream, int quantity) {
        if (iceCream == null) {
            throw new IllegalArgumentException("IceCream cannot be null for an OrderItem.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive for an OrderItem.");
        }
        this.iceCream = iceCream;
        this.quantity = quantity;
    }

    public IceCream getIceCream() {
        return iceCream;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return iceCream.getBasePrice() * quantity;
    }

    @Override
    public String toString() {
        return quantity + "x " + iceCream.getName() + " ($" + String.format("%.2f", iceCream.getBasePrice()) + " each) - Subtotal: $" + String.format("%.2f", getSubtotal());
    }
}