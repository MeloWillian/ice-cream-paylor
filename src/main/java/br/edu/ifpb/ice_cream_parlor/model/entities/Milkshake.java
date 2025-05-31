package br.edu.ifpb.ice_cream_parlor.model.entities;

// Classe que representa um milkshake.
public class Milkshake implements IceCream {
    private String baseFlavor;  // Sabor base do milkshake.
    private double basePrice;   // Preço base do milkshake.
    private String size;        // Tamanho (ex: "S", "M", "L").

    public Milkshake(String baseFlavor, double basePrice, String size) {
        this.baseFlavor = baseFlavor;
        this.basePrice = basePrice; // Preço pode ser ajustado com base no tamanho na Factory ou aqui.
        this.size = size;
    }

    @Override
    public String getName() {
        return baseFlavor + " Milkshake (" + size + ")"; // Nome formatado.
    }

    @Override
    public double getBasePrice() {
        // Lógica de preço pode ser mais complexa dependendo do tamanho.
        // Por simplicidade, o preço base já considera o tamanho aqui.
        return basePrice;
    }

    @Override
    public String getDescription() {
        return "Creamy " + baseFlavor + " flavored milkshake, size " + size + "."; // Descrição.
    }

    // Getter para o sabor base.
    public String getBaseFlavor() {
        return baseFlavor;
    }

    // Setter para o sabor base.
    public void setBaseFlavor(String baseFlavor) {
        this.baseFlavor = baseFlavor;
    }

    // Getter para o tamanho.
    public String getSize() {
        return size;
    }

    // Setter para o tamanho.
    public void setSize(String size) {
        this.size = size;
    }

    // Setter para o preço base.
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}
