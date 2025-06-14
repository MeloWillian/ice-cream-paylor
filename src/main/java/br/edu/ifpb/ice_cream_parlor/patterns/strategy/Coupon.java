package br.edu.ifpb.ice_cream_parlor.patterns.strategy;

public interface Coupon {

    // Retorna nome do desconto
    String getName();

    // Retorna o código do cupom: Achei melhor para adicionar ao pedido no banco
    String getCode();

    // Aplica desconto
    double applyDiscount(double totalAmount);
}
