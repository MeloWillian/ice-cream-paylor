package br.edu.ifpb.ice_cream_parlor.patterns.state;

import br.edu.ifpb.ice_cream_parlor.model.entities.Order;

public class NewOrder implements OrderState {

    @Override
    public void next(Order order) {
        order.setStatus(new Preparation());
    }

    @Override
    public void cancel(Order order) {
        order.setStatus(new Canceled());
    }

    @Override
    public String getStatus() {
        return "Novo pedido";
    }
}
