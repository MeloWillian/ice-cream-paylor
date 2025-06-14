package br.edu.ifpb.ice_cream_parlor.patterns.factory;

import br.edu.ifpb.ice_cream_parlor.patterns.state.*;

public class OrderStateFactory {

    public static OrderState create(String status) {
        return switch (status.toLowerCase()) {
            case "novo" -> new NewOrder();
            case "em preparo" -> new Preparation();
            case "aguardando retirada" -> new Withdrawal();
            case "finalizado" -> new Finished();
            default -> throw new IllegalArgumentException("Status desconhecido: " + status);
        };
    }
}
