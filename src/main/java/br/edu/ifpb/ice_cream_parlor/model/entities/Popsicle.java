package br.edu.ifpb.ice_cream_parlor.model.entities;

// Classe que representa um picolé.
public class Popsicle implements IceCream {
    private String flavor;      // Sabor do picolé.
    private double basePrice;   // Preço base do picolé.

    public Popsicle(String flavor, double basePrice) {
        this.flavor = flavor;
        this.basePrice = basePrice;
    }

    @Override
    public String getName() {
        return "Popsicle of " + flavor; // Nome formatado do picolé.
    }

    @Override
    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String getDescription() {
        return "Delicious " + flavor + " flavored popsicle."; // Descrição do picolé.
    }

    // Getter para o sabor.
    public String getFlavor() {
        return flavor;
    }

    // Setter para o sabor.
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    // Setter para o preço base.
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}