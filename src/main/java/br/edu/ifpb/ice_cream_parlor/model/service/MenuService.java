package br.edu.ifpb.ice_cream_parlor.model.service;

import br.edu.ifpb.ice_cream_parlor.patterns.decorator.IceCream;
import br.edu.ifpb.ice_cream_parlor.model.entities.enums.IceCreamType;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.IceCreamFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

// Serviço para gerenciar o menu da sorveteria.
public class MenuService {

    // TODO: Sabores disponíveis para cada tipo devem vir de um repository.
    private static final Map<IceCreamType, List<String>> availableFlavors = new HashMap<>();

    static {
        availableFlavors.put(IceCreamType.POPSICLE, Arrays.asList("Chocolate", "Strawberry"));
        availableFlavors.put(IceCreamType.SCOOPED, Arrays.asList("Vanilla", "Chocochips"));
        availableFlavors.put(IceCreamType.MILKSHAKE, Arrays.asList("Chocolate", "Strawberry"));
    }

    // Retorna uma lista dos nomes dos tipos de sorvete disponíveis.
    public List<String> getAvailableIceCreamTypeNames() {
        List<String> typeNames = new ArrayList<>();
        for (IceCreamType type : IceCreamType.values()) {
            typeNames.add(type.name());
        }
        return typeNames;
    }

    // Retorna uma lista dos sabores disponíveis para um tipo específico de sorvete.
    public List<String> getAvailableFlavorsForType(IceCreamType type) {
        return availableFlavors.getOrDefault(type, new ArrayList<>());
    }

    // Solicita um sorvete usando os parâmetros padrão da fábrica.
    // TODO: Colocar em facade. Pode adicionar lógica de disponibilidade aqui se necessário.
    public IceCream requestIceCream(IceCreamType type, String flavor) {
        return IceCreamFactory.createIceCream(type, flavor);
    }

    // Solicita um sorvete de massa especificando o número de bolas.
    // TODO: Colocar em facade. Pode adicionar lógica de disponibilidade aqui se necessário.
    public IceCream requestScoopedIceCream(String flavor, int numberOfScoops) {
        return IceCreamFactory.createIceCream(IceCreamType.SCOOPED, flavor, numberOfScoops, null);
    }

    // Solicita um milkshake especificando o tamanho.
    // TODO: Colocar em facade. Pode adicionar lógica de disponibilidade aqui se necessário.
    public IceCream requestMilkshake(String flavor, String size) {
        return IceCreamFactory.createIceCream(IceCreamType.MILKSHAKE, flavor, 1, size); // 1 é irrelevante aqui, mas a factory espera.
    }

}