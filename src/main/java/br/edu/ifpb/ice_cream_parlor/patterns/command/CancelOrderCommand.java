package br.edu.ifpb.ice_cream_parlor.patterns.command;

import br.edu.ifpb.ice_cream_parlor.patterns.facade.IceCreamParlorFacade;

public class CancelOrderCommand implements Command {

    private final IceCreamParlorFacade facade;
    private final String orderId;

    public CancelOrderCommand(IceCreamParlorFacade facade, String orderId) {
        this.facade = facade;
        this.orderId = orderId;
    }

    @Override
    public void execute() {
        facade.cancelOrder(orderId);
    }

    @Override
    public void undo() {
        System.out.println("⚠️ Não é possível desfazer cancelamento diretamente.");
        // Poderíamos salvar o estado do pedido e recriá-lo, mas isso exigiria mais controle.
    }

    @Override
    public void redo() {
        execute();
    }
}
