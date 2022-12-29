package BehavioralPatterns.Strategy;

import BehavioralPatterns.ChainOfResponsability.Voucher;
import BehavioralPatterns.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> items;
    private List<Voucher> vouchers;
    private int orderNumber;
    private double priceTotal;

    public ShoppingCart(int orderNumber) {
        this.items = new ArrayList<>();
        this.vouchers = new ArrayList<>();
        this.orderNumber = orderNumber;
    }

    public void addItem(Product product) {
        this.items.add(product);
    }

    public void removeItem(Product product) {
        this.items.remove(product);
    }

    public void addVoucher(Voucher voucher) {
        this.vouchers.add(voucher);
    }

    public void removeVoucher(Voucher voucher) { this.vouchers.remove(voucher); }

    public boolean isFirstOrder(){
        if(orderNumber==1) return true;
        else return false;
    }

    public List<Product> getItems(){
        return items;
    }

    public List<Voucher> getVouchers(){
        return vouchers;
    }

    public double calculateSubTotal() {
        for (Product product : items) {
            priceTotal += product.getPrice();
        }
        return priceTotal;
    }

    public void applyDiscountInPrct(double percentages) {
        this.priceTotal = priceTotal * percentages;
    }

    public void pay(PaymentStrategy paymentMethod) {
        paymentMethod.pay(priceTotal);
    }

}
