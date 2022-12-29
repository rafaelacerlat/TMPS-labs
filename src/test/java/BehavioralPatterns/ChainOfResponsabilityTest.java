package BehavioralPatterns;

import BehavioralPatterns.ChainOfResponsability.DiscountByVoucher;
import BehavioralPatterns.ChainOfResponsability.FirstPurchase;
import BehavioralPatterns.ChainOfResponsability.Voucher;
import BehavioralPatterns.Strategy.Paypal;
import BehavioralPatterns.Strategy.ShoppingCart;
import org.junit.jupiter.api.Test;

public class ChainOfResponsabilityTest {

    @Test
    public void testCOR(){
        Product laptop = new Product("A001", "Notebook", 999);
        Product phone = new Product("B003","Samsung", 500);

        Voucher voucher1 = new Voucher("VOUCHER_1", 0.9);
        Voucher voucher2 = new Voucher("NEWYEAR", 0.8);

        ShoppingCart cart = new ShoppingCart(1);

        cart.addItem(laptop);
        cart.addItem(phone);

        cart.addVoucher(voucher1);
        cart.addVoucher(voucher2);

        cart.calculateSubTotal();

        FirstPurchase firstPurchase = new FirstPurchase(null, cart);
        DiscountByVoucher discountByVoucher = new DiscountByVoucher(firstPurchase, cart);

        firstPurchase.handleRequest();

        cart.pay(new Paypal("testEmail@randommailservice.com", "password"));
    }
}
