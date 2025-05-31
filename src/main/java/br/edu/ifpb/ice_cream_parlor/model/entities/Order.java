package br.edu.ifpb.ice_cream_parlor.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID; // Para um ID único simples.

// Representa um pedido feito na sorveteria.
public class Order {
    private String id;                      // Identificador único do pedido.
    private List<OrderItem> items;          // Lista de itens no pedido.
    //TODO: Desenvolver outros atributos como cliente, data, status.

    public Order() {
        this.id = UUID.randomUUID().toString(); // Gera um ID aleatório.
        this.items = new ArrayList<>();
    }

    // Retorna o ID do pedido.
    public String getId() {
        return id;
    }

    // Retorna a lista de itens do pedido (cópia defensiva para imutabilidade externa da lista).
    public List<OrderItem> getItems() {
        return new ArrayList<>(items); // Retorna uma cópia.
    }

    // Adiciona um item ao pedido.
    public void addItem(OrderItem item) {
        if (item != null) {
            this.items.add(item);
        }
    }

    // Adiciona um sorvete com uma quantidade específica como um novo item ao pedido.
    public void addItem(IceCream iceCream, int quantity) {
        if (iceCream != null && quantity > 0) {
            this.items.add(new OrderItem(iceCream, quantity));
        }
    }

    // Calcula o valor total do pedido (sem descontos ou taxas por enquanto).
    public double getTotalAmount() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    // Representação em string do pedido.
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
