package br.edu.ifpb.ice_cream_parlor.patterns.command.main_menu;

import br.edu.ifpb.ice_cream_parlor.cli.RegisterMenu;
import br.edu.ifpb.ice_cream_parlor.controller.MenuUI;
import br.edu.ifpb.ice_cream_parlor.patterns.command.Command;

public class ShowRegisterMenuCommand implements Command {

    @Override
    public void execute() {
        RegisterMenu register = new RegisterMenu();
        MenuUI registerUI = new MenuUI(register);
        registerUI.start();
    }

    @Override
    public void undo() {

    }
}
