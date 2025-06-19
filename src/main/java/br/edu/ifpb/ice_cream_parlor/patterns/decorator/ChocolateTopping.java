package br.edu.ifpb.ice_cream_parlor.patterns.decorator;

public class ChocolateTopping extends IceCreamDecorator {
    public ChocolateTopping(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public String getDescription() {
        return decoratedIceCream.getDescription() + " + chocolate topping";
    }

    @Override
    public double getBasePrice() {
        return decoratedIceCream.getBasePrice() + 1.00;
    }
}
