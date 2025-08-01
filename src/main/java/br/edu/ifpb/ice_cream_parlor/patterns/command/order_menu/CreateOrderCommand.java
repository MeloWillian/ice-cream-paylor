package br.edu.ifpb.ice_cream_parlor.patterns.command.order_menu;

import br.edu.ifpb.ice_cream_parlor.patterns.command.Command;
import br.edu.ifpb.ice_cream_parlor.patterns.facade.IceCreamParlorFacade;

import java.util.Scanner;

public class CreateOrderCommand implements Command {

    private final IceCreamParlorFacade facade = IceCreamParlorFacade.getInstance();
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void execute() {
        try {
            if (!facade.hasCurrentOrder()) {
                System.out.print("👤 Digite o nome do cliente: ");
                String clientName = sc.nextLine().trim();

                if (clientName.isEmpty()) {
                    System.out.println("⚠️ Nome do cliente não pode ser vazio.");
                    return;
                }

                facade.startOrder(clientName);
            }

            boolean adding = true;
            while (adding) {
                facade.addItemToCurrentOrder();

                System.out.print("Deseja adicionar outro item ao pedido? (S/N): ");
                String response = sc.nextLine().trim();
                adding = response.equalsIgnoreCase("S");
            }

        } catch (Exception e) {
            System.out.println("❌ Erro ao criar ou montar pedido: " + e.getMessage());
        }
    }

    @Override
    public void undo() {

    }
}
