package br.edu.ifpb.ice_cream_parlor.patterns.strategy;

public class SeasonalDiscountCoupon implements Coupon {

    @Override
    public String getName() {
        return "Desconto de verão";
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.10;
    }
}
