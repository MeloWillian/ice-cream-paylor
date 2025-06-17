package br.edu.ifpb.ice_cream_parlor.patterns.command.history_menu;

import br.edu.ifpb.ice_cream_parlor.patterns.command.Command;
import br.edu.ifpb.ice_cream_parlor.patterns.facade.IceCreamParlorFacade;

public class DisplayHistoryCommand implements Command {

    private final IceCreamParlorFacade facade = IceCreamParlorFacade.getInstance();

    @Override
    public void execute() {
        facade.displayHistoryOrders();
    }

    @Override
    public void undo() {

    }
}
