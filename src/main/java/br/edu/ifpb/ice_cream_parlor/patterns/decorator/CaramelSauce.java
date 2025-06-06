package br.edu.ifpb.ice_cream_parlor.patterns.decorator;

public class CaramelSauce extends IceCreamDecorator {
    public CaramelSauce(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public String getDescription() {
        return decoratedIceCream.getDescription() + " + caramel sauce";
    }

    @Override
    public double getBasePrice() {
        return decoratedIceCream.getBasePrice() + 0.90;
    }
}
