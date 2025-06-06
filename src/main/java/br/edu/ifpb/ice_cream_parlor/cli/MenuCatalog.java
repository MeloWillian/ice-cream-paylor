package br.edu.ifpb.ice_cream_parlor.cli;

import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.*;

public class MenuCatalog implements Menu {

    @Override
    public void show() {
        System.out.println("\n" + YELLOW + "=== 📋 CARDÁPIO ===" + RESET);
        System.out.println("1. Listar sabores disponíveis");
        System.out.println("2. Ver tipos de sorvete");
        System.out.println("3. Ver complementos");
        System.out.println("0. Voltar ao menu principal");
        System.out.print("Por favor, escolha uma opção: ");
    }

    @Override
    public void handleInput(String input) {
        switch (input) {
            case "1":
                System.out.println("\nSabores disponíveis:");
                System.out.println("- Chocolate");
                System.out.println("- Morango");
                System.out.println("- Baunilha");
                System.out.println("- Flocos");
                System.out.println("- Caramelo");
                System.out.println("- Menta");
                break;
            case "2":
                System.out.println("\nTipos de sorvete:");
                System.out.println("- Picolé");
                System.out.println("- Massa");
                System.out.println("- Milkshake");
                break;
            case "3":
                System.out.println("\nComplementos disponíveis:");
                System.out.println("- Calda quente");
                System.out.println("- Chantilly");
                System.out.println("- Granulado");
                System.out.println("- Castanha");
                break;
            case "0":
                System.out.println("Retornando ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
