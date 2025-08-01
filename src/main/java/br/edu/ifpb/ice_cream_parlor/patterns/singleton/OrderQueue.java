package br.edu.ifpb.ice_cream_parlor.patterns.singleton;
import br.edu.ifpb.ice_cream_parlor.exceptions.EmptyQueueException;
import br.edu.ifpb.ice_cream_parlor.model.entities.Order;

import java.util.LinkedList;
import java.util.Queue;

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

    public Order peek(){
        return queue.peek();
    }

    public void addOrder(Order order) {
        if (order != null) {
            queue.add(order);
        }
    }

    public void removeOrder(Order order) {
        if(order != null) {
            queue.remove(order);
        }
    }

    public Order processNextOrder() throws EmptyQueueException{
        Order nextOrder = queue.poll();
        if (nextOrder == null) {
            throw new EmptyQueueException("empty queue");
        }
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

    @Override
    public String toString() {
        return "OrderQueue{" +
                "queue=" + queue +
                '}';
    }
}