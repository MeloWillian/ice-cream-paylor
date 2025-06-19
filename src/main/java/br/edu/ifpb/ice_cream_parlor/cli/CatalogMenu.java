package br.edu.ifpb.ice_cream_parlor.cli;

import br.edu.ifpb.ice_cream_parlor.patterns.command.catalog_menu.ListAvailableFlavorsCommand;
import br.edu.ifpb.ice_cream_parlor.patterns.command.catalog_menu.ListIcecreamComplementsCommand;
import br.edu.ifpb.ice_cream_parlor.patterns.command.catalog_menu.ListTypesIcecreamCommand;

import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.*;

public class CatalogMenu implements Menu {

    @Override
    public void show() {
        System.out.println("\n" + YELLOW + "=== 📋 CARDÁPIO ===" + RESET);
        System.out.println("1. Listar sabores disponíveis");
        System.out.println("2. Ver tipos de sorvete");
        System.out.println("3. Ver complementos");
        System.out.println("0. Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }

    @Override
    public void handleInput(String input) {
        switch (input) {
            case "1":
                ListAvailableFlavorsCommand listAvailableFlavors = new ListAvailableFlavorsCommand();
                listAvailableFlavors.execute();
                break;
            case "2":
                ListTypesIcecreamCommand listTypesIcecreamCommand = new ListTypesIcecreamCommand();
                listTypesIcecreamCommand.execute();
                break;
            case "3":
                ListIcecreamComplementsCommand listIcecreamComplementsCommand = new ListIcecreamComplementsCommand();
                listIcecreamComplementsCommand.execute();
                break;
            case "0":
                System.out.println("Retornando ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
