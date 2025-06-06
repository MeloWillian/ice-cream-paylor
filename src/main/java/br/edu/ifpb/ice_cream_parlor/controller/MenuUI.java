package br.edu.ifpb.ice_cream_parlor.controller;
import br.edu.ifpb.ice_cream_parlor.cli.Menu;

import java.util.Scanner;

public class MenuUI {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

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
