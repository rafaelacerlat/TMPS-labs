package BehavioralPatterns.ChainOfResponsability;

import BehavioralPatterns.Product;
import BehavioralPatterns.Strategy.ShoppingCart;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

abstract class Discount implements ChainDiscount {

    private final ShoppingCart shoppingCart;
    private final Discount successor;


    protected Map<String, List<Product>> getGroupingItems() {
        if (isNull(shoppingCart)) {
            return Collections.emptyMap();
        }
        return shoppingCart.getItems().stream().collect(Collectors.groupingBy(Product::getName));
    }


    public Discount(Discount successor, ShoppingCart shoppingCart) {
        this.successor = successor;
        this.shoppingCart = shoppingCart;
    }

    boolean next() {
        if (nonNull(successor)) {
            return successor.handleRequest();
        }
        return false;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

}
