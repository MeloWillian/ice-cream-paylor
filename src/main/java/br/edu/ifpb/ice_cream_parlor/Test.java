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

public class Test {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        MenuUI ui = new MenuUI(mainMenu);
        ui.start();

//        OrderStatusNotifier notifier = new OrderStatusNotifier();
//        Client client = new Client("Jéfter");
//        client.setId("65a2ff97-6ab7-4690-9adb-dd9a9c290d48");
//
//        Order order = new Order(notifier);
//        order.setClient(client);
//        order.setCoupon(new SeasonalDiscountCoupon());
//
//        IceCream base = IceCreamFactory.createIceCream(IceCreamType.POPSICLE, "Chocolate");
//        IceCream iceCreamTest = IceCreamFactory.createIceCream(IceCreamType.POPSICLE, "Chocolate");
//        IceCream personalized = new ChocolateTopping(new WhippedCream(base));
//
//        IceCream scoopedIceCream = IceCreamFactory.createIceCream(IceCreamType.SCOOPED, "Vanilla");
//        IceCream scoopedIceCreamPersonalized = new CaramelSauce(scoopedIceCream);

//        order.addItem(new OrderItem(personalized, 2));
//        order.addItem(new OrderItem(iceCreamTest, 1));
//        order.addItem(new OrderItem(scoopedIceCreamPersonalized, 1));

//        System.out.println("Sub total: "+order.getSubTotal());
//        System.out.println("Total: "+order.getTotal());
//
//        OrderRepository orderRepository = new OrderRepository();
//        List<OrderView> orders = orderRepository.findByClientId("65a2ff97-6ab7-4690-9adb-dd9a9c290d48");
//        System.out.println(orders);

//        orderRepository.save(order);

//        #################### CLIENT #########################
//        ClientRepository clientRepository = new ClientRepository();
//        List clients = clientRepository.findAll();
//
//        System.out.println(clients);
//        Client client = new Client("Jéfter Lucas");
//
//        Client savedClient = clientRepository.save(client);
////        System.out.println("Cliente salvo com ID: " + savedClient.getId());
//
//        List<Client> findClients = clientRepository.findByName("Lucas");
//        System.out.println(findClients);
//        ############ __ END CLIENT __ #########################

    }
}
