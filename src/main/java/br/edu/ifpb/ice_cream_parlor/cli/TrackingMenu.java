package br.edu.ifpb.ice_cream_parlor.cli;

import br.edu.ifpb.ice_cream_parlor.patterns.command.tracking_menu.UpdateStatusOrderCommand;
import br.edu.ifpb.ice_cream_parlor.patterns.command.tracking_menu.CancelOrderCommand;
import br.edu.ifpb.ice_cream_parlor.patterns.command.tracking_menu.ShowCurrentOrderCommand;

import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.*;
import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.RESET;

public class TrackingMenu implements Menu {

    @Override
    public void show() {
        ShowCurrentOrderCommand showCurrentOrderCommand = new ShowCurrentOrderCommand();
        System.out.println("\n" + PURPLE + "=== 🧾 ACOMPANHAR PEDIDOS ===" + RESET);
        showCurrentOrderCommand.execute();
        System.out.println("1. Atualizar Status");
        System.out.println("2. Cancelar");
        System.out.println("0. Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }

    @Override
    public void handleInput(String input) {
        switch (input) {
            case "1":
                UpdateStatusOrderCommand updateStatusOrderCommand = new UpdateStatusOrderCommand();
                updateStatusOrderCommand.execute();
                break;
            case "2":
                CancelOrderCommand cancelOrderCommand = new CancelOrderCommand();
                cancelOrderCommand.execute();
                break;
            case "0":
                System.out.println("Retornando ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
