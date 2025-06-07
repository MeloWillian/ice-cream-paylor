package br.edu.ifpb.ice_cream_parlor.patterns.observer;

import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.*;

public class ClientNotification implements Observer {

    private final String clientName;

    public ClientNotification(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void update(String orderId, String status) {
        System.out.printf(
                "🔔 Olá %s%s%s! seu pedido [%s%s%s] está: %s%s%s%n",
                BOLD, clientName, RESET,
                YELLOW_BOLD, orderId, RESET,
                CYAN_BOLD, status.toUpperCase(), RESET
        );
    }
}
