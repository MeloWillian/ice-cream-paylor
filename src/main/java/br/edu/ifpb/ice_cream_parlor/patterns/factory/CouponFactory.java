package br.edu.ifpb.ice_cream_parlor.patterns.factory;

import br.edu.ifpb.ice_cream_parlor.patterns.strategy.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class CouponFactory {

    private static final Map<String, String> availableCoupons = new LinkedHashMap<>();

    static {
        availableCoupons.put("SEASONAL", "Desconto de verão");
        availableCoupons.put("FREQUENT", "Cliente frequente");
    }

    public static Coupon createCoupon(String couponCode) {
        if (couponCode == null) {
            return null;
        }

        switch (couponCode.toUpperCase()) {
            case "SEASONAL":
                return new SeasonalDiscountCoupon();
            case "FREQUENT":
                return new FrequentCustomerDiscountCoupon();
            default:
                throw new IllegalArgumentException("Cupom desconhecido: " + couponCode);
        }
    }

    public static Map<String, String> getAvailableCoupons() {
        return availableCoupons;
    }
}
