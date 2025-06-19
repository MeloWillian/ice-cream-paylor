package br.edu.ifpb.ice_cream_parlor.patterns.command.main_menu;

import br.edu.ifpb.ice_cream_parlor.cli.CatalogMenu;
import br.edu.ifpb.ice_cream_parlor.controller.MenuUI;
import br.edu.ifpb.ice_cream_parlor.patterns.command.Command;

public class ShowCatalogMenuCommand implements Command {

    @Override
    public void execute() {
        CatalogMenu catalog = new CatalogMenu();
        MenuUI catalogUI = new MenuUI(catalog);
        catalogUI.start();
    }

    @Override
    public void undo() {

    }
}
