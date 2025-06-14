package br.edu.ifpb.ice_cream_parlor.model.entities;

import br.edu.ifpb.ice_cream_parlor.patterns.decorator.IceCream;

// Classe que representa sorvete de massa.
public class ScoopedIceCream implements IceCream {
    private String flavor;           // Sabor do sorvete de massa.
    private double pricePerScoop;    // Preço por bola.
    private int numberOfScoops;      // Número de bolas.

    public ScoopedIceCream(String flavor, double pricePerScoop, int numberOfScoops) {
        this.flavor = flavor;
        this.pricePerScoop = pricePerScoop;
        this.numberOfScoops = numberOfScoops;
    }

    @Override
    public String getName() {
        return "Scooped Ice Cream (" + flavor + ")"; // Nome formatado.
    }

    @Override
    public double getBasePrice() {
        return pricePerScoop * numberOfScoops; // Preço base calculado pelo número de bolas.
    }

    @Override
    public String getDescription() {
        return getName() + " " +numberOfScoops+" scopes"; // Descrição.
    }

    // Getter para o sabor.
    public String getFlavor() {
        return flavor;
    }

    // Setter para o sabor.
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    // Getter para o preço por bola.
    public double getPricePerScoop() {
        return pricePerScoop;
    }

    // Setter para o preço por bola.
    public void setPricePerScoop(double pricePerScoop) {
        this.pricePerScoop = pricePerScoop;
    }

    // Getter para o número de bolas.
    public int getNumberOfScoops() {
        return numberOfScoops;
    }

    // Setter para o número de bolas.
    public void setNumberOfScoops(int numberOfScoops) {
        this.numberOfScoops = numberOfScoops;
    }
}
