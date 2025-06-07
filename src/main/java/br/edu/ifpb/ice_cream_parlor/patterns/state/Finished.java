package br.edu.ifpb.ice_cream_parlor.patterns.state;

import br.edu.ifpb.ice_cream_parlor.model.entities.Order;

public class Finished implements OrderState {

    @Override
    public void next(Order order) {
        System.out.println("Pedido já finalizado.");
    }

    @Override
    public String getStatus() {
        return "Finalizado";
    }
}
