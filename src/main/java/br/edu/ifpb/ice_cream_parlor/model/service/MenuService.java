package br.edu.ifpb.ice_cream_parlor.model.service;

import br.edu.ifpb.ice_cream_parlor.model.entities.enums.IceCreamType;
import br.edu.ifpb.ice_cream_parlor.patterns.facade.IceCreamParlorFacade;

import java.util.*;

public class MenuService {

    private final IceCreamParlorFacade facade;

    // Sabores disponíveis por tipo de sorvete (mock; idealmente viria de um repositório).
    private static final Map<IceCreamType, List<String>> availableFlavors = new HashMap<>();

    static {
        availableFlavors.put(IceCreamType.POPSICLE, Arrays.asList("Chocolate", "Strawberry"));
        availableFlavors.put(IceCreamType.SCOOPED, Arrays.asList("Vanilla", "Chocochips"));
        availableFlavors.put(IceCreamType.MILKSHAKE, Arrays.asList("Chocolate", "Strawberry"));
    }

    public MenuService(IceCreamParlorFacade facade) {
        this.facade = facade;
    }

    // Retorna os nomes dos tipos de sorvete disponíveis.
    public List<String> getAvailableIceCreamTypeNames() {
        List<String> typeNames = new ArrayList<>();
        for (IceCreamType type : IceCreamType.values()) {
            typeNames.add(type.name());
        }
        return typeNames;
    }

    // Retorna os sabores disponíveis para um tipo específico.
    public List<String> getAvailableFlavorsForType(IceCreamType type) {
        return availableFlavors.getOrDefault(type, new ArrayList<>());
    }

    // Encaminha a adição de um item ao pedido via fachada.
    public void addItemToOrder(String orderId, IceCreamType type, String flavor, int scoops, String size, int quantity) {
        facade.addItemToOrder(orderId, type, flavor, scoops, size, quantity);
    }
}
