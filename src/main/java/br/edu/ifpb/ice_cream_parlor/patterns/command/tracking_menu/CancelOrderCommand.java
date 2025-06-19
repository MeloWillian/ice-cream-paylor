package br.edu.ifpb.ice_cream_parlor.patterns.command.tracking_menu;

import br.edu.ifpb.ice_cream_parlor.patterns.command.Command;
import br.edu.ifpb.ice_cream_parlor.patterns.facade.IceCreamParlorFacade;

public class CancelOrderCommand implements Command {

    private final IceCreamParlorFacade facade = IceCreamParlorFacade.getInstance();

    @Override
    public void execute() {
        facade.cancelStatus();
    }

    @Override
    public void undo() {

    }
}
