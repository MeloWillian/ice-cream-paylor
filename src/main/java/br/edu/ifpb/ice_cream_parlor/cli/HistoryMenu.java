package br.edu.ifpb.ice_cream_parlor.cli;

import br.edu.ifpb.ice_cream_parlor.patterns.command.history_menu.DisplayHistoryCommand;

import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.GREEN;
import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.RESET;

public class HistoryMenu implements Menu {

    @Override
    public void show() {
        System.out.println("\n" + GREEN + "=== 🧾 ACOMPANHAR PEDIDOS ===" + RESET);
        System.out.println("1. Exibir histórico");
        System.out.println("0. Voltar ao menu principal");
        System.out.print("Por favor, escolha uma opção: ");
    }

    @Override
    public void handleInput(String input) {
        switch (input) {
            case "1":
                DisplayHistoryCommand displayHistoryCommand = new DisplayHistoryCommand();
                displayHistoryCommand.execute();
                break;

            case "0":
                System.out.println("Retornando ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
