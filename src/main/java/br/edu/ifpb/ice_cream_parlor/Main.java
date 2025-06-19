package br.edu.ifpb.ice_cream_parlor;

import br.edu.ifpb.ice_cream_parlor.cli.MainMenu;
import br.edu.ifpb.ice_cream_parlor.controller.MenuUI;
import br.edu.ifpb.ice_cream_parlor.model.entities.Client;
import br.edu.ifpb.ice_cream_parlor.model.entities.Order;
import br.edu.ifpb.ice_cream_parlor.model.entities.OrderItem;
import br.edu.ifpb.ice_cream_parlor.model.entities.enums.IceCreamType;
import br.edu.ifpb.ice_cream_parlor.model.view.OrderItemView;
import br.edu.ifpb.ice_cream_parlor.model.view.OrderView;
import br.edu.ifpb.ice_cream_parlor.patterns.decorator.CaramelSauce;
import br.edu.ifpb.ice_cream_parlor.patterns.decorator.ChocolateTopping;
import br.edu.ifpb.ice_cream_parlor.patterns.decorator.IceCream;
import br.edu.ifpb.ice_cream_parlor.patterns.decorator.WhippedCream;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.ConnectionFactory;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.ConnectionFactoryProvider;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.IceCreamFactory;
import br.edu.ifpb.ice_cream_parlor.patterns.observer.OrderStatusNotifier;
import br.edu.ifpb.ice_cream_parlor.patterns.repository.ClientRepository;
import br.edu.ifpb.ice_cream_parlor.patterns.repository.OrderRepository;
import br.edu.ifpb.ice_cream_parlor.patterns.strategy.FrequentCustomerDiscountCoupon;
import br.edu.ifpb.ice_cream_parlor.patterns.strategy.SeasonalDiscountCoupon;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        MenuUI ui = new MenuUI(mainMenu);
        ui.start();
    }
}
