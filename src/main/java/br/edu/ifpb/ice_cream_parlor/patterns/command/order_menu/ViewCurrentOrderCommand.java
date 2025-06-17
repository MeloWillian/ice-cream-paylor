package br.edu.ifpb.ice_cream_parlor.patterns.command.order_menu;

import br.edu.ifpb.ice_cream_parlor.patterns.facade.IceCreamParlorFacade;
import br.edu.ifpb.ice_cream_parlor.patterns.command.Command;

public class ViewCurrentOrderCommand implements Command {

    private final IceCreamParlorFacade facade = IceCreamParlorFacade.getInstance();

    @Override
    public void execute() {
        facade.viewCurrentOrder();
    }

    @Override
    public void undo() {

    }
}
