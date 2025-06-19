package br.edu.ifpb.ice_cream_parlor.model.entities.enums;

import java.util.List;

// Enumeração para os diferentes tipos de sorvete disponíveis.
public enum IceCreamType {
    POPSICLE(List.of("Chocolate", "Strawberry")),
    SCOOPED(List.of("Vanilla", "Chocochips")),
    MILKSHAKE(List.of("Chocolate", "Strawberry"));

    private final List<String> flavors;

    IceCreamType(List<String> flavors) {
        this.flavors = flavors;
    }

    public List<String> getFlavors() {
        return flavors;
    }
}