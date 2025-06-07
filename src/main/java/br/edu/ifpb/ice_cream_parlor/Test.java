package br.edu.ifpb.ice_cream_parlor;

import br.edu.ifpb.ice_cream_parlor.cli.MainMenu;
import br.edu.ifpb.ice_cream_parlor.controller.MenuUI;
import br.edu.ifpb.ice_cream_parlor.model.entities.Client;
import br.edu.ifpb.ice_cream_parlor.model.entities.Order;
import br.edu.ifpb.ice_cream_parlor.patterns.observer.ClientNotification;
import br.edu.ifpb.ice_cream_parlor.patterns.observer.OrderStatusNotifier;

public class Test {

    public static void main(String[] args) {
        Client cliente = new Client("Fernanda");
        ClientNotification notificacao = new ClientNotification(cliente.getName());

        OrderStatusNotifier notifier = new OrderStatusNotifier();
        notifier.addObserver(notificacao);

        Order pedido = new Order(cliente, notifier); // estado: Novo pedido
        pedido.nextState(); // Em preparo
        pedido.nextState(); // Pronto para retirada
        pedido.nextState(); // Finalizado
        pedido.nextState(); // Já finalizado
    }

}
