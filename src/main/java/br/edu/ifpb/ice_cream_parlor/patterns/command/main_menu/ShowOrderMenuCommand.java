package br.edu.ifpb.ice_cream_parlor.patterns.command.main_menu;

import br.edu.ifpb.ice_cream_parlor.cli.OrderMenu;
import br.edu.ifpb.ice_cream_parlor.controller.MenuUI;
import br.edu.ifpb.ice_cream_parlor.patterns.command.Command;

public class ShowOrderMenuCommand implements Command {
    @Override
    public void execute() {
        OrderMenu orderMenu = new OrderMenu();
        MenuUI orderMenuUI = new MenuUI(orderMenu);
        orderMenuUI.start();
    }

    @Override
    public void undo() {

    }
}
