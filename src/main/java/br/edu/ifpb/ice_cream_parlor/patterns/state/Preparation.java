package br.edu.ifpb.ice_cream_parlor.patterns.state;

import br.edu.ifpb.ice_cream_parlor.model.entities.Order;

public class Preparation implements OrderState {

    @Override
    public void next(Order order) {
        order.setStatus(new Withdrawal());
    }

    @Override
    public void cancel(Order order) {
        order.setStatus(new Canceled());
    }

    @Override
    public String getStatus() {
        return "Em preparo";
    }
}
