package br.edu.ifpb.ice_cream_parlor.patterns.singleton;
import br.edu.ifpb.ice_cream_parlor.exceptions.EmptyQueueException;
import br.edu.ifpb.ice_cream_parlor.model.entities.Order;

import java.util.LinkedList;
import java.util.Queue;

// Gerencia a fila de pedidos da sorveteria usando o padrão Singleton.
public class OrderQueue {
    private static OrderQueue instance;
    private Queue<Order> queue;

    private OrderQueue() {
        queue = new LinkedList<>();
    }

    public static OrderQueue getInstance() {
        if (instance == null) {
            instance = new OrderQueue();
        }
        return instance;
    }

    public void addOrder(Order order) {
        if (order != null) {
            queue.add(order);
            System.out.println("Order " + order.getId() + " added to the queue.");
        }
    }

    public Order processNextOrder() throws Exception{
        Order nextOrder = queue.poll(); // poll retorna null se a fila estiver vazia.
        if (nextOrder == null) {
            throw new EmptyQueueException("empty queue");
        }
        System.out.println("Processing order: " + nextOrder.getId());
        return nextOrder;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int getQueueSize() {
        return queue.size();
    }

    public void clearQueue() {
        queue.clear();
        System.out.println("Order queue cleared.");
    }
}