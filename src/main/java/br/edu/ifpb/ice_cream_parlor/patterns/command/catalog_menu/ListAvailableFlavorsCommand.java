package br.edu.ifpb.ice_cream_parlor.patterns.command.catalog_menu;

import br.edu.ifpb.ice_cream_parlor.patterns.command.Command;

public class ListAvailableFlavorsCommand implements Command {
    @Override
    public void execute() {
        System.out.println("\nSabores disponíveis:");
        System.out.println("- Chocolate");
        System.out.println("- Morango");
        System.out.println("- Baunilha");
        System.out.println("- Flocos");
        System.out.println("- Caramelo");
        System.out.println("- Menta");
    }

    @Override
    public void undo() {

    }
}
