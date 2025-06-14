package br.edu.ifpb.ice_cream_parlor.patterns.command.catalog_menu;

import br.edu.ifpb.ice_cream_parlor.patterns.command.Command;

public class ListIcecreamComplementsCommand implements Command {
    @Override
    public void execute() {
        System.out.println("\nComplementos disponíveis:");
        System.out.println("- Calda quente");
        System.out.println("- Chantilly");
        System.out.println("- Granulado");
        System.out.println("- Castanha");
    }

    @Override
    public void undo() {

    }
}
