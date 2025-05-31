package br.edu.ifpb.ice_cream_parlor.patterns.singleton;
import br.edu.ifpb.ice_cream_parlor.model.entities.Order;

import java.util.LinkedList;
import java.util.Queue;

// Gerencia a fila de pedidos da sorveteria usando o padrão Singleton.
// Esta implementação é básica e não é thread-safe para ambientes concorrentes.
// Para concorrência, considere `java.util.concurrent.ConcurrentLinkedQueue` e sincronização aprimorada.
public class OrderQueue {
    private static OrderQueue instance; // A única instância da fila.
    private Queue<Order> queue;       // A fila de pedidos interna.

    // Construtor privado para impedir a instanciação direta.
    private OrderQueue() {
        queue = new LinkedList<>();
    }

    // Método para obter a instância única da fila (inicialização preguiçosa).
    public static OrderQueue getInstance() {
        if (instance == null) {
            instance = new OrderQueue();
        }
        return instance;
    }

    // Adiciona um pedido à fila.
    public void addOrder(Order order) {
        if (order != null) {
            queue.add(order);
            System.out.println("Order " + order.getId() + " added to the queue.");
        }
    }

    // Remove e retorna o próximo pedido da fila.
    public Order processNextOrder() throws Exception{
        Order nextOrder = queue.poll(); // poll retorna null se a fila estiver vazia.
        if (nextOrder == null) {
            throw new Exception("empty queue");
        }
        System.out.println("Processing order: " + nextOrder.getId());
        return nextOrder;
    }

    // Verifica se a fila está vazia.
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Retorna o número de pedidos na fila.
    public int getQueueSize() {
        return queue.size();
    }

    // Limpa todos os pedidos da fila (útil para testes ou reinicialização).
    public void clearQueue() {
        queue.clear();
        System.out.println("Order queue cleared.");
    }
}