package br.edu.ifpb.ice_cream_parlor;


import br.edu.ifpb.ice_cream_parlor.patterns.decorator.IceCream;
import br.edu.ifpb.ice_cream_parlor.model.entities.enums.IceCreamType;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.IceCreamFactory;
import br.edu.ifpb.ice_cream_parlor.model.service.MenuService;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Ice Cream Parlor!"); // Bem-vindo à Sorveteria!

        System.out.println("\n--- Testing Factory directly ---"); // Testando Factory diretamente
        IceCream chocoPopsicle = IceCreamFactory.createIceCream(IceCreamType.POPSICLE, "Chocolate");
        System.out.println("Created: " + chocoPopsicle.getName() + " - Price: $" + chocoPopsicle.getBasePrice()); // Criado ... Preço
        System.out.println("Description: " + chocoPopsicle.getDescription()); // Descrição

        IceCream vanillaScooped = IceCreamFactory.createIceCream(IceCreamType.SCOOPED, "Vanilla", 2, null); // 2 bolas
        System.out.println("Created: " + vanillaScooped.getName() + " - Price: $" + vanillaScooped.getBasePrice());
        System.out.println("Description: " + vanillaScooped.getDescription());

        IceCream strawberryMilkshake = IceCreamFactory.createIceCream(IceCreamType.MILKSHAKE, "Strawberry", 1, "L"); // Tamanho G (L para Large)
        System.out.println("Created: " + strawberryMilkshake.getName() + " - Price: $" + strawberryMilkshake.getBasePrice());
        System.out.println("Description: " + strawberryMilkshake.getDescription());

        try {
            IceCream unknownIceCream = IceCreamFactory.createIceCream(IceCreamType.POPSICLE, "Grape"); // Uva
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage()); // Erro esperado
        }

        System.out.println("\n--- Testing MenuService ---"); // Testando MenuService
        MenuService menuService = new MenuService();

        System.out.println("Available Ice Cream Types: " + menuService.getAvailableIceCreamTypeNames()); // Tipos de Sorvete Disponíveis
        System.out.println("Available flavors for POPSICLE: " + menuService.getAvailableFlavorsForType(IceCreamType.POPSICLE)); // Sabores para PICOLE

        IceCream orderedFromMenu = menuService.requestScoopedIceCream("Chocochips", 3); // Flocos
        System.out.println("\nOrdered via MenuService: " + orderedFromMenu.getName() + " - Price: $" + orderedFromMenu.getBasePrice()); // Pedido via MenuService

    }
}