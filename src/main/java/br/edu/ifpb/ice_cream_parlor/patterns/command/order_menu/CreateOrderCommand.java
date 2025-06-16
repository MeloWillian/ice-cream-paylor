package br.edu.ifpb.ice_cream_parlor.patterns.command.order_menu;

import br.edu.ifpb.ice_cream_parlor.patterns.command.Command;
import br.edu.ifpb.ice_cream_parlor.patterns.facade.IceCreamParlorFacade;

import java.util.Scanner;

public class CreateOrderCommand implements Command {

    private final IceCreamParlorFacade facade = new IceCreamParlorFacade();

    @Override
    public void execute() {

//        Scanner sc = new Scanner(System.in);
//        String name = sc.next();
//        facade.createOrder(name);


    }

    @Override
    public void undo() {

    }
}
