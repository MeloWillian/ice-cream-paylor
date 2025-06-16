package br.edu.ifpb.ice_cream_parlor.cli;

import br.edu.ifpb.ice_cream_parlor.patterns.command.tracking_menu.ListFinishedOrderCommand;
import br.edu.ifpb.ice_cream_parlor.patterns.command.tracking_menu.ListNewOrderCommand;
import br.edu.ifpb.ice_cream_parlor.patterns.command.tracking_menu.ListPreparationOrderCommand;
import br.edu.ifpb.ice_cream_parlor.patterns.command.tracking_menu.ListWithdrawalOrderCommand;

import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.*;
import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.RESET;

public class TrackingMenu implements Menu {

    @Override
    public void show() {
        System.out.println("\n" + PURPLE + "=== 🧾 ACOMPANHAR PEDIDOS ===" + RESET);
        System.out.println("1. Novos pedidos");
        System.out.println("2. Em preparo");
        System.out.println("3. Prontos para retirada");
        System.out.println("4. Finalizados");
        System.out.println("0. Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }

    @Override
    public void handleInput(String input) {
        switch (input) {
            case "1":
                ListNewOrderCommand listNewOrderCommand = new ListNewOrderCommand();
                listNewOrderCommand.execute();
                break;
            case "2":
                ListPreparationOrderCommand listPreparationOrderCommand = new ListPreparationOrderCommand();
                listPreparationOrderCommand.execute();
                break;
            case "3":
                ListWithdrawalOrderCommand listWithdrawalOrderCommand = new ListWithdrawalOrderCommand();
                listWithdrawalOrderCommand.execute();
                break;
            case "4":
                ListFinishedOrderCommand listFinishedOrderCommand = new ListFinishedOrderCommand();
                listFinishedOrderCommand.execute();
                break;
            case "0":
                System.out.println("Retornando ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
