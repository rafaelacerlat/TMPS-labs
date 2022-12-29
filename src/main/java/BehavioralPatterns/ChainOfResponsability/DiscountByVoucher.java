package BehavioralPatterns.ChainOfResponsability;

import BehavioralPatterns.Strategy.ShoppingCart;

public class DiscountByVoucher extends Discount{

    public DiscountByVoucher(Discount successor, ShoppingCart shoppingCart) {
        super(successor, shoppingCart);
    }

    @Override
    public boolean handleRequest() {
        Voucher voucher = getShoppingCart().getVouchers().stream()
                .filter(v -> v.getName().equals("NEWYEAR_23")).findFirst().get();
        if (voucher != null){
            getShoppingCart().applyDiscountInPrct(voucher.getPercentages());
            return true;
        }
        return next();
    }
}
