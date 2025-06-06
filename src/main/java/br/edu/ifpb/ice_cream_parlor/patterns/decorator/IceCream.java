package br.edu.ifpb.ice_cream_parlor.patterns.decorator;

// Interface que representa um sorvete genérico.
public interface IceCream {
    // Retorna o nome do sorvete (ex: "Picolé de Chocolate", "Sorvete de Massa (Baunilha)").
    String getName();
    // Retorna o preço base do sorvete, antes de quaisquer adicionais ou descontos.
    double getBasePrice();
    // Retorna uma descrição básica do tipo de sorvete.
    String getDescription();
}