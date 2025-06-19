package br.edu.ifpb.ice_cream_parlor.cli;

import br.edu.ifpb.ice_cream_parlor.controller.MenuUI;
import br.edu.ifpb.ice_cream_parlor.patterns.command.main_menu.*;

import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.*;

public class MainMenu implements Menu {

    @Override
    public void show() {
        System.out.println("\n" + BLUE + "=== 🍦 Sorveteria ===" + RESET);
        System.out.println("1. Fazer novo pedido");
        System.out.println("2. Acompanhar pedidos");
        System.out.println("3. Ver cardápio");
        System.out.println("4. Histórico de pedidos");
        System.out.println("5. Cadastro");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    @Override
    public void handleInput(String input) {
        switch (input) {
            case "1":
                ShowOrderMenuCommand showOrderMenuCommand = new ShowOrderMenuCommand();
                showOrderMenuCommand.execute();
                break;
            case "2":
                ShowTrackingMenuCommand showTrackingMenuCommand = new ShowTrackingMenuCommand();
                showTrackingMenuCommand.execute();
                break;
            case "3":
                ShowCatalogMenuCommand showCatalogMenuCommand = new ShowCatalogMenuCommand();
                showCatalogMenuCommand.execute();
                break;
            case "4":
                ShowHistoryMenuCommand showHistoryMenuCommand = new ShowHistoryMenuCommand();
                showHistoryMenuCommand.execute();
                break;
            case "5":
                ShowRegisterMenuCommand showRegisterMenuCommand = new ShowRegisterMenuCommand();
                showRegisterMenuCommand.execute();
                break;
            case "0":
                System.out.println("Encerrando aplicação. Até logo!");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
