package br.edu.ifpb.ice_cream_parlor.patterns.strategy;

public class FrequentCustomerDiscountCoupon implements Coupon{

    @Override
    public String getName() {
        return "Cliente frequente";
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.15;
    }
}
