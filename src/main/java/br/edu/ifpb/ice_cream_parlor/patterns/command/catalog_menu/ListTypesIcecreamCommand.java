package br.edu.ifpb.ice_cream_parlor.patterns.command.catalog_menu;

import br.edu.ifpb.ice_cream_parlor.patterns.command.Command;

public class ListTypesIcecreamCommand implements Command {
    @Override
    public void execute() {
        System.out.println("\nTipos de sorvete:");
        System.out.println("1 Picolé");
        System.out.println("2 Massa");
        System.out.println("3 Milkshake");
    }

    @Override
    public void undo() {

    }
}
