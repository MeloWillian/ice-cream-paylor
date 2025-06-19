package br.edu.ifpb.ice_cream_parlor.patterns.strategy;

public class NoDiscount implements Coupon{

    @Override
    public String getCode() {
        return "SEM_DESCONTO";
    }

    @Override
    public String getName() {
        return "SEM DESCONTO";
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return 0;
    }
}
