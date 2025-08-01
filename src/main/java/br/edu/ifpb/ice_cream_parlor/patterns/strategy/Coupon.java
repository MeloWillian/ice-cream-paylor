package br.edu.ifpb.ice_cream_parlor.patterns.strategy;

public interface Coupon {

    String getName();

    String getCode();

    double applyDiscount(double totalAmount);
}
