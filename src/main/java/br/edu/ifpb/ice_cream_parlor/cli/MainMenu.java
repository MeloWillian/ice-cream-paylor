package br.edu.ifpb.ice_cream_parlor.cli;

import br.edu.ifpb.ice_cream_parlor.controller.MenuUI;
import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.*;

public class MainMenu implements Menu {

    @Override
    public void show() {
        System.out.println("\n" + BLUE + "=== 🍦 Sorveteria ===" + RESET);
        System.out.println("1. Fazer novo pedido");
        System.out.println("2. Acompanhar pedido");
        System.out.println("3. Ver cardápio");
        System.out.println("4. Histórico de pedidos");
        System.out.println("5. Login / Cadastro");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    @Override
    public void handleInput(String input) {
        switch (input) {
            case "1":
                OrderMenu orderMenu = new OrderMenu();
                MenuUI orderMenuUI = new MenuUI(orderMenu);
                orderMenuUI.start(); // Executa o submenu do cardápio
                break;
            case "3":
                MenuCatalog catalog = new MenuCatalog();
                MenuUI catalogUI = new MenuUI(catalog);
                catalogUI.start(); // Executa o submenu do cardápio
                break;
            case "0":
                System.out.println("Encerrando aplicação. Até logo!");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
