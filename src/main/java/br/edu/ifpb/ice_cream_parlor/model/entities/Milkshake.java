package br.edu.ifpb.ice_cream_parlor.model.entities;

import br.edu.ifpb.ice_cream_parlor.patterns.decorator.IceCream;


public class Milkshake implements IceCream {
    private String baseFlavor;
    private double basePrice;
    private String size;

    public Milkshake(String baseFlavor, double basePrice, String size) {
        this.baseFlavor = baseFlavor;
        this.basePrice = basePrice;
        this.size = size;
    }

    @Override
    public String getName() {
        return baseFlavor + " Milkshake (" + size + ")"; // Nome formatado.
    }

    @Override
    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String getDescription() {
        return "Creamy " + baseFlavor + " flavored milkshake, size " + size + "."; // Descrição.
    }

    public String getBaseFlavor() {
        return baseFlavor;
    }

    public void setBaseFlavor(String baseFlavor) {
        this.baseFlavor = baseFlavor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}
