package br.edu.ifpb.ice_cream_parlor.patterns.command.register_menu;

import br.edu.ifpb.ice_cream_parlor.patterns.command.Command;
import br.edu.ifpb.ice_cream_parlor.patterns.facade.IceCreamParlorFacade;

public class ListClientsCommand implements Command {
    private final IceCreamParlorFacade facade = IceCreamParlorFacade.getInstance();

    @Override
    public void execute() {
        facade.listClients();
    }

    @Override
    public void undo() {

    }
}
