package BehavioralPatterns;

import BehavioralPatterns.Strategy.CreditCard;
import BehavioralPatterns.Strategy.Paypal;
import BehavioralPatterns.Strategy.ShoppingCart;
import org.junit.jupiter.api.Test;

public class StrategyTest {
    @Test
    public void testStrategy() {
        ShoppingCart cart = new ShoppingCart(3); // this is the third order

        Product laptop = new Product("A001", "Notebook", 999);
        Product phone = new Product("B003","Samsung", 500);

        cart.addItem(laptop);
        cart.addItem(phone);

        cart.calculateSubTotal();

        cart.pay(new Paypal("testEmail@randommailservice.com", "password"));

        cart.pay(new CreditCard("Rafaela", "1234567890123456", "786", "12/22"));
    }
}
