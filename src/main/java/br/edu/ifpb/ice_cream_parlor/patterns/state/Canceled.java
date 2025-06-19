package br.edu.ifpb.ice_cream_parlor.patterns.state;

import br.edu.ifpb.ice_cream_parlor.model.entities.Order;

public class Canceled implements OrderState {
    @Override
    public void next(Order order) {

    }

    @Override
    public void cancel(Order order) {

    }

    @Override
    public String getStatus() {
        return "Cancelado";
    }
}
