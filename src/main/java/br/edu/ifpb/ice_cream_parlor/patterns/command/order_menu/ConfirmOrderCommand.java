package br.edu.ifpb.ice_cream_parlor.patterns.command.order_menu;

import br.edu.ifpb.ice_cream_parlor.patterns.command.Command;
import br.edu.ifpb.ice_cream_parlor.patterns.facade.IceCreamParlorFacade;

public class ConfirmOrderCommand implements Command {

    private final IceCreamParlorFacade facade = IceCreamParlorFacade.getInstance();

    @Override
    public void execute() {
        facade.confirmOrder();
    }

    @Override
    public void undo() {
        facade.cancelOrder();
    }
}
