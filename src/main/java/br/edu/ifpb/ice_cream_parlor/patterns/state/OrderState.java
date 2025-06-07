package br.edu.ifpb.ice_cream_parlor.patterns.state;

import br.edu.ifpb.ice_cream_parlor.model.entities.Order;

public interface OrderState {
    void next(Order order);
    String getStatus();
}
