package br.edu.ifpb.ice_cream_parlor.patterns.strategy;

public class NoDiscount implements Coupon{

    @Override
    public String getName() {
        return "Sem desconto";
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return 0;
    }
}
