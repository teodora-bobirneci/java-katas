package katas.backtocheckout;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Checkout {

    private final Map<Character, Integer> priceList;
    private final Map<Character, Promotion> promotions;

    private Map<Character, Integer> purchase = new HashMap<>();

    public Checkout(Map<Character, Integer> priceList, Map<Character, Promotion> promotions) {
        this.priceList = priceList;
        this.promotions = promotions;
    }

    public Checkout(Map<Character, Integer> priceList) {
        this.priceList = priceList;
        this.promotions = Collections.emptyMap();
    }

    public void scan(char productCode) {
        if (purchase.containsKey(productCode)) {
            purchase.put(productCode, purchase.get(productCode) + 1);
        } else {
            purchase.put(productCode, 1);
        }
    }

    public int total() {
        int total = 0;

        for (Map.Entry<Character, Integer> item : purchase.entrySet()){
            if (isProductOnPromotion(item.getKey())){
                total += getPromotionalPriceFor(item.getKey(), item.getValue());
            } else {
                total += item.getValue() * priceList.get(item.getKey());
            }
        }

        return total;
    }

    private int getPromotionalPriceFor(Character productCode, Integer quantity) {
        if (quantity < promotions.get(productCode).forQuantity){
            return quantity * priceList.get(productCode);
        }
        return promotions.get(productCode).promoPrice + getPromotionalPriceFor(productCode, quantity - promotions.get(productCode).forQuantity);
    }

    private boolean isProductOnPromotion(Character productCode) {
        return promotions.containsKey(productCode);
    }
}
