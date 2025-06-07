package br.edu.ifpb.ice_cream_parlor.patterns.command;

import br.edu.ifpb.ice_cream_parlor.patterns.facade.IceCreamParlorFacade;

public class CreateOrderCommand implements Command {

    private final IceCreamParlorFacade facade;
    private final String clientName;
    private String orderId;

    public CreateOrderCommand(IceCreamParlorFacade facade, String clientName) {
        this.facade = facade;
        this.clientName = clientName;
    }

    @Override
    public void execute() {
        orderId = facade.createOrder(clientName);
    }

    @Override
    public void undo() {
        if (orderId != null) {
            facade.cancelOrder(orderId);
        } else {
            System.out.println("⚠️ Nenhum pedido para cancelar.");
        }
    }

    @Override
    public void redo() {
        execute();
    }

    public String getOrderId() {
        return orderId;
    }
}
