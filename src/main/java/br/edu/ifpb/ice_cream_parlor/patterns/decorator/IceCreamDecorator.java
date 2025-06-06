package br.edu.ifpb.ice_cream_parlor.patterns.decorator;

public abstract class IceCreamDecorator implements IceCream {
    protected IceCream decoratedIceCream;

    public IceCreamDecorator(IceCream iceCream) {
        this.decoratedIceCream = iceCream;
    }

    @Override
    public String getName() {
        return decoratedIceCream.getName();
    }

    @Override
    public double getBasePrice() {
        return decoratedIceCream.getBasePrice();
    }

    @Override
    public String getDescription() {
        return decoratedIceCream.getDescription();
    }
}
