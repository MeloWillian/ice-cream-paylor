package br.edu.ifpb.ice_cream_parlor.patterns.factory;

import br.edu.ifpb.ice_cream_parlor.patterns.strategy.*;

public class CouponFactory {

    public static Coupon createCoupon(String couponCode) {
        if (couponCode == null) {
            return null;
        }

        switch (couponCode) {
            case "SEASONAL":
            case "Desconto de verão":
                return new SeasonalDiscountCoupon();

            case "FREQUENT":
            case "Cliente frequente":
                return new FrequentCustomerDiscountCoupon();

            default:
                throw new IllegalArgumentException("Cupom desconhecido: " + couponCode);
        }
    }
}
