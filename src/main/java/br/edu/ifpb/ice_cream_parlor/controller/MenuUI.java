package br.edu.ifpb.ice_cream_parlor.controller;

import br.edu.ifpb.ice_cream_parlor.cli.Menu;

import java.util.Scanner;

public class MenuUI {
    public static final String RESET = "\u001B[0m";

    private final Scanner scanner = new Scanner(System.in);
    private final Menu menu;

    public MenuUI(Menu menu) {
        this.menu = menu;
    }

    public void start() {
        String input;
        do {
            menu.show();
            input = scanner.nextLine();
            menu.handleInput(input);
        } while (!input.equals("0"));
    }
}
