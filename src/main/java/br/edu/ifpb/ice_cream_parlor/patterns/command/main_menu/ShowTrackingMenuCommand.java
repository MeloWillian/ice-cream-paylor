package br.edu.ifpb.ice_cream_parlor.patterns.command.main_menu;

import br.edu.ifpb.ice_cream_parlor.cli.TrackingMenu;
import br.edu.ifpb.ice_cream_parlor.controller.MenuUI;
import br.edu.ifpb.ice_cream_parlor.patterns.command.Command;

public class ShowTrackingMenuCommand implements Command {

    @Override
    public void execute() {
        TrackingMenu trackingMenu = new TrackingMenu();
        MenuUI trackingMenuUI = new MenuUI(trackingMenu);
        trackingMenuUI.start();
    }

    @Override
    public void undo() {

    }
}
