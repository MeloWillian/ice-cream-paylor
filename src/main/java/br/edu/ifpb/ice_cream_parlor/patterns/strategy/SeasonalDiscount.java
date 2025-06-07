package br.edu.ifpb.ice_cream_parlor.patterns.strategy;

public class SeasonalDiscount implements Coupon {

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.15;
    }
}
