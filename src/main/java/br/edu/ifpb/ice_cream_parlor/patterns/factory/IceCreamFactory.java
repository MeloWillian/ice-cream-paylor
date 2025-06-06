package br.edu.ifpb.ice_cream_parlor.patterns.factory;

import br.edu.ifpb.ice_cream_parlor.model.entities.Milkshake;
import br.edu.ifpb.ice_cream_parlor.model.entities.Popsicle;
import br.edu.ifpb.ice_cream_parlor.model.entities.IceCream;
import br.edu.ifpb.ice_cream_parlor.model.entities.ScoopedIceCream;
import br.edu.ifpb.ice_cream_parlor.model.entities.enums.IceCreamType;

// Fábrica para criar diferentes tipos de objetos Sorvete.
public class IceCreamFactory {

    // TODO: Preços base deve vir de um arquivo de configuração ou banco de dados.
    private static final double PRICE_POPSICLE_CHOCOLATE = 3.50;
    private static final double PRICE_POPSICLE_STRAWBERRY = 3.00;
    private static final double PRICE_SCOOP_VANILLA = 5.00;
    private static final double PRICE_SCOOP_CHOCOCHIPS = 5.50; // Flocos = Chocochips
    private static final double PRICE_MILKSHAKE_CHOCOLATE_M = 12.00;
    private static final double PRICE_MILKSHAKE_STRAWBERRY_M = 11.00;


    // Método de fábrica principal para criar sorvetes com parâmetros padrão.
    public static IceCream createIceCream(IceCreamType type, String flavor) {
        // Para SorveteMassa e Milkshake, podemos adicionar mais parâmetros se necessário
        // ou ter métodos mais específicos na factory.
        // Por simplicidade inicial, vamos usar um número de bolas e tamanho padrão.
        return createIceCream(type, flavor, 1, "M"); // 1 bola, tamanho Médio por padrão
    }

    // Método de fábrica sobrecarregado para maior controle na criação.
    public static IceCream createIceCream(IceCreamType type, String flavor, int numberOfScoops, String milkshakeSize) {
        switch (type) {
            case POPSICLE:
                if ("Chocolate".equalsIgnoreCase(flavor)) {
                    return new Popsicle(flavor, PRICE_POPSICLE_CHOCOLATE);
                } else if ("Strawberry".equalsIgnoreCase(flavor)) { // Morango
                    return new Popsicle(flavor, PRICE_POPSICLE_STRAWBERRY);
                }
                throw new IllegalArgumentException("Unknown popsicle flavor: " + flavor);
            case SCOOPED:
                if ("Vanilla".equalsIgnoreCase(flavor)) { // Baunilha
                    return new ScoopedIceCream(flavor, PRICE_SCOOP_VANILLA, numberOfScoops);
                } else if ("Chocochips".equalsIgnoreCase(flavor)) { // Flocos
                    return new ScoopedIceCream(flavor, PRICE_SCOOP_CHOCOCHIPS, numberOfScoops);
                }
                throw new IllegalArgumentException("Unknown scooped ice cream flavor: " + flavor);
            case MILKSHAKE:
                if ("Chocolate".equalsIgnoreCase(flavor)) {
                    return new Milkshake(flavor, PRICE_MILKSHAKE_CHOCOLATE_M, milkshakeSize);
                } else if ("Strawberry".equalsIgnoreCase(flavor)) { // Morango
                    return new Milkshake(flavor, PRICE_MILKSHAKE_STRAWBERRY_M, milkshakeSize);
                }
                throw new IllegalArgumentException("Unknown milkshake flavor: " + flavor);
            default:
                throw new IllegalArgumentException("Unknown ice cream type: " + type);
        }
    }
}