//package br.edu.ifpb.ice_cream_parlor.patterns.command;
//
//import br.edu.ifpb.ice_cream_parlor.model.entities.Order;
//import br.edu.ifpb.ice_cream_parlor.model.entities.enums.IceCreamType;
//import br.edu.ifpb.ice_cream_parlor.patterns.decorator.IceCream;
//import br.edu.ifpb.ice_cream_parlor.patterns.facade.IceCreamParlorFacade;
//
//public class RedoOrderCommand implements Command {
//
//    private final IceCreamParlorFacade facade;
//    private final String originalOrderId;
//    private String newOrderId;
//
//    public RedoOrderCommand(IceCreamParlorFacade facade, String originalOrderId) {
//        this.facade = facade;
//        this.originalOrderId = originalOrderId;
//    }
//
//    @Override
//    public void execute() {
//        Order original = facade.getOrderById(originalOrderId);
//        if (original == null) {
//            System.out.println("⚠️ Pedido original não encontrado.");
//            return;
//        }
//
//        String clientName = original.getClientName();
//        newOrderId = facade.createOrder(clientName);
//
//        original.getItems().forEach((item, quantity) -> {
//            IceCream iceCream = (IceCream) item;
//            facade.addItemToOrder(
//                    newOrderId,
//                    iceCream.getType(),
//                    iceCream.getFlavor(),
//                    iceCream.getScoops(),
//                    iceCream.getSize(),
//                    quantity
//            );
//        });
//
//        System.out.println("🔁 Pedido refeito com ID: " + newOrderId);
//    }
//
//    @Override
//    public void undo() {
//        if (newOrderId != null) {
//            facade.cancelOrder(newOrderId);
//            System.out.println("↩️ Pedido refeito cancelado: " + newOrderId);
//        }
//    }
//
//    @Override
//    public void redo() {
//        execute();
//    }
//}
//
