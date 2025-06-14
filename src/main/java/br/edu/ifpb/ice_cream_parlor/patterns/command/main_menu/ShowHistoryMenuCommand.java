package br.edu.ifpb.ice_cream_parlor.patterns.command.main_menu;

import br.edu.ifpb.ice_cream_parlor.cli.HistoryMenu;
import br.edu.ifpb.ice_cream_parlor.controller.MenuUI;
import br.edu.ifpb.ice_cream_parlor.patterns.command.Command;

public class ShowHistoryMenuCommand implements Command {

    @Override
    public void execute() {
        HistoryMenu historyMenu = new HistoryMenu();
        MenuUI historyMenuUI = new MenuUI(historyMenu);
        historyMenuUI.start();
    }

    @Override
    public void undo() {

    }
}
