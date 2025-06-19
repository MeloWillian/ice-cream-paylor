package br.edu.ifpb.ice_cream_parlor.patterns.decorator;

import br.edu.ifpb.ice_cream_parlor.model.entities.enums.IceCreamType;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.IceCreamFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IceCreamDecoratorTest {

    @Test
    void testBaseIceCream() {
        IceCream base = IceCreamFactory.createIceCream(IceCreamType.POPSICLE, "Chocolate");

        System.out.println("🧁 Pedido base:");
        System.out.println("Nome: " + base.getName());
        System.out.println("Descrição: " + base.getDescription());
        System.out.println("Preço: R$" + base.getBasePrice());

        assertEquals("Popsicle of Chocolate", base.getName());
        assertTrue(base.getDescription().toLowerCase().contains("chocolate"));
        assertEquals(3.50, base.getBasePrice(), 0.01);
    }

    @Test
    void testCustomizedIceCream() {
        IceCream base = IceCreamFactory.createIceCream(IceCreamType.POPSICLE, "Chocolate");
        IceCream personalized = new ChocolateTopping(new WhippedCream(base));

        System.out.println("\n🍫 Pedido personalized:");
        System.out.println("Nome: " + personalized.getName());
        System.out.println("Descrição: " + personalized.getDescription());
        System.out.println("Preço: R$" + personalized.getBasePrice());

//        assertEquals("Chocolate Popsicle", personalized.getName());
//        assertTrue(personalized.getDescription().contains("chocolate topping"));
//        assertTrue(personalized.getDescription().contains("whipped cream"));
//        assertEquals(3.50 + 0.75 + 1.00, personalized.getBasePrice(), 0.01);
    }
}
