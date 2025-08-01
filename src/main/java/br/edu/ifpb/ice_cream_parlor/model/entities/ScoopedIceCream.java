package br.edu.ifpb.ice_cream_parlor.model.entities;

import br.edu.ifpb.ice_cream_parlor.patterns.decorator.IceCream;

public class ScoopedIceCream implements IceCream {
    private String flavor;
    private double pricePerScoop;
    private int numberOfScoops;

    public ScoopedIceCream(String flavor, double pricePerScoop, int numberOfScoops) {
        this.flavor = flavor;
        this.pricePerScoop = pricePerScoop;
        this.numberOfScoops = numberOfScoops;
    }

    @Override
    public String getName() {
        return "Scooped Ice Cream (" + flavor + ")";
    }

    @Override
    public double getBasePrice() {
        return pricePerScoop * numberOfScoops;
    }

    @Override
    public String getDescription() {
        return getName() + " " +numberOfScoops+" scopes"; // Descrição.
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPricePerScoop() {
        return pricePerScoop;
    }

    public void setPricePerScoop(double pricePerScoop) {
        this.pricePerScoop = pricePerScoop;
    }

    public int getNumberOfScoops() {
        return numberOfScoops;
    }

    public void setNumberOfScoops(int numberOfScoops) {
        this.numberOfScoops = numberOfScoops;
    }
}
