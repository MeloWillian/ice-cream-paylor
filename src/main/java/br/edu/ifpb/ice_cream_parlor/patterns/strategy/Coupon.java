package br.edu.ifpb.ice_cream_parlor.patterns.strategy;

public interface Coupon {

    // Retorna nome do desconto
    String getName();

    // Aplica desconto
    double applyDiscount(double totalAmount);
}
