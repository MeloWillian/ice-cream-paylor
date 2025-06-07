package br.edu.ifpb.ice_cream_parlor;

import br.edu.ifpb.ice_cream_parlor.cli.MainMenu;
import br.edu.ifpb.ice_cream_parlor.controller.MenuUI;
import br.edu.ifpb.ice_cream_parlor.patterns.observer.ClientNotification;

public class Test {
    public static void main(String[] args) {
//        MainMenu mainMenu = new MainMenu();
//        MenuUI ui = new MenuUI(mainMenu);
//        ui.start();

        ClientNotification client = new ClientNotification("Alice");
        client.update("ORDER-123", "Delivered");
    }
}
