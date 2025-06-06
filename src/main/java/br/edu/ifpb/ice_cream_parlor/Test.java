package br.edu.ifpb.ice_cream_parlor;

import br.edu.ifpb.ice_cream_parlor.cli.MainMenu;
import br.edu.ifpb.ice_cream_parlor.controller.MenuUI;

public class Test {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        MenuUI ui = new MenuUI(mainMenu);
        ui.start();
    }
}
