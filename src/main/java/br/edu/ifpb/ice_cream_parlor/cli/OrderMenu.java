package br.edu.ifpb.ice_cream_parlor.cli;

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

        switch (input) {
            case "1":
                // TODO: Monta o pedido

                break;
            case "2":
                // TODO: Aplicar cupom de desconto

                break;
            case "3":
                // TODO: Confirma o pedido

                break;
            case "4":
                // TODO: Cancela

                break;
            case "0":
                System.out.println("Retornando ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
