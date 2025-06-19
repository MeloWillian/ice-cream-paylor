package br.edu.ifpb.ice_cream_parlor.patterns.decorator;

public class WhippedCream extends IceCreamDecorator {
    public WhippedCream(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public String getDescription() {
        return decoratedIceCream.getDescription() + " + whipped cream";
    }

    @Override
    public double getBasePrice() {
        return decoratedIceCream.getBasePrice() + 0.75;
    }
}
