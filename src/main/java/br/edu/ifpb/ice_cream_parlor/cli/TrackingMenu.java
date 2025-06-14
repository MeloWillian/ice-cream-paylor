package br.edu.ifpb.ice_cream_parlor.cli;

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
        System.out.print("Por favor, escolha uma opção: ");
    }

    @Override
    public void handleInput(String input) {
        switch (input) {
            case "1":
                // TODO: listar novos pedidos do banco

                break;
            case "2":
                // TODO: listar pedidos em preparo do banco

                break;
            case "3":
                // TODO: listar pedidos prontos para retirada do banco

                break;
            case "4":
                // TODO: listar pedidos finalizados do banco

                break;
            case "0":
                System.out.println("Retornando ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
