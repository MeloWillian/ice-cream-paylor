package br.edu.ifpb.ice_cream_parlor.cli;

import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.*;

public class OrderMenu implements Menu {

    @Override
    public void show() {
        System.out.println("\n" + CYAN + "=== 🧾 NOVO PEDIDO ===" + RESET);
        System.out.println("1. Escolher tipo de sorvete");
        System.out.println("2. Escolher sabor");
        System.out.println("3. Adicionar complementos");
        System.out.println("4. Aplicar cupom ou desconto");
        System.out.println("5. Confirmar pedido");
        System.out.println("6. Cancelar pedido");
        System.out.println("7. Refazer último pedido");
        System.out.println("0. Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }

    @Override
    public void handleInput(String input) {

    }
}
