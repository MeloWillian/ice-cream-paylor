package br.edu.ifpb.ice_cream_parlor.patterns.observer;

public class ClientNotification implements Observer {

    private final String clientName;

    public ClientNotification(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void update(String orderId, String status) {
        System.out.printf("🔔 Olá %s! seu pedido [%s] está: %s%n", clientName, orderId, status);
    }
}
