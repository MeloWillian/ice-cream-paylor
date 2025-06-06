package br.edu.ifpb.ice_cream_parlor.model.entities;

import br.edu.ifpb.ice_cream_parlor.patterns.decorator.IceCream;

// Representa um item individual dentro de um pedido.
public class OrderItem {
    private IceCream iceCream; // O sorvete deste item.
    private int quantity;      // Quantidade deste sorvete.

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

    // Retorna o sorvete associado a este item.
    public IceCream getIceCream() {
        return iceCream;
    }

    // Retorna a quantidade deste item.
    public int getQuantity() {
        return quantity;
    }

    // Calcula o subtotal para este item do pedido.
    public double getSubtotal() {
        return iceCream.getBasePrice() * quantity;
    }

    // Representação em string do item do pedido.
    @Override
    public String toString() {
        return quantity + "x " + iceCream.getName() + " ($" + String.format("%.2f", iceCream.getBasePrice()) + " each) - Subtotal: $" + String.format("%.2f", getSubtotal());
    }
}