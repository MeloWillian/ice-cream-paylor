package br.edu.ifpb.ice_cream_parlor.cli;

import br.edu.ifpb.ice_cream_parlor.patterns.command.order_menu.ApplyDiscountCommand;
import br.edu.ifpb.ice_cream_parlor.patterns.command.order_menu.ConfirmOrderCommand;
import br.edu.ifpb.ice_cream_parlor.patterns.command.order_menu.CreateOrderCommand;

import java.util.Scanner;

import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.*;

public class OrderMenu implements Menu {

    @Override
    public void show() {
        System.out.println("\n" + CYAN + "=== 🧾 NOVO PEDIDO ===" + RESET);
        System.out.println("1. Montar sorvetes");
        System.out.println("2. Aplicar cupom ou desconto");
        System.out.println("3. Confirmar pedido");
        System.out.println("4. Cancelar pedido");
        System.out.println("0. Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }

    @Override
    public void handleInput(String input) {
        ConfirmOrderCommand confirmOrderCommand = new ConfirmOrderCommand();
        CreateOrderCommand createOrderCommand = new CreateOrderCommand();
        ApplyDiscountCommand applyDiscountCommand = new ApplyDiscountCommand();

        switch (input) {
            case "1":
                createOrderCommand.execute();
                break;
            case "2":
                applyDiscountCommand.execute();
                break;
            case "3":
                confirmOrderCommand.execute();
                break;
            case "4":
                confirmOrderCommand.undo();
                break;
            case "0":
                System.out.println("Retornando ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
