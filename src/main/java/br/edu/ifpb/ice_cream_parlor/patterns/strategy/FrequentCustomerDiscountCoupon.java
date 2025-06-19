package br.edu.ifpb.ice_cream_parlor.patterns.strategy;

public class FrequentCustomerDiscountCoupon implements Coupon{

    @Override
    public String getCode() {
        return "CLIENTE_FREQUENTE";
    }

    @Override
    public String getName() {
        return "15% para cliente frequente";
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.15;
    }
}
