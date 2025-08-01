package br.edu.ifpb.ice_cream_parlor.model.entities;

import br.edu.ifpb.ice_cream_parlor.patterns.decorator.IceCream;

public class Popsicle implements IceCream {
    private String flavor;
    private double basePrice;

    public Popsicle(String flavor, double basePrice) {
        this.flavor = flavor;
        this.basePrice = basePrice;
    }

    @Override
    public String getName() {
        return "Popsicle of " + flavor;
    }

    @Override
    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String getDescription() {
        return getName();
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}