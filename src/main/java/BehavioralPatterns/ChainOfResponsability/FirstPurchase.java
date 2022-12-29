package BehavioralPatterns.ChainOfResponsability;

import BehavioralPatterns.Strategy.ShoppingCart;

public class FirstPurchase extends Discount {

    public FirstPurchase(Discount successor, ShoppingCart shoppingCart) {
        super(successor, shoppingCart);
    }

    @Override
    public boolean handleRequest() {
        if(getShoppingCart().isFirstOrder()) {
            getShoppingCart().applyDiscountInPrct(0.9);
            return true;
        }
        return next();
    }
}
