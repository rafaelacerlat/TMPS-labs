package BehavioralPatterns;

import BehavioralPatterns.Template.NetOrder;
import BehavioralPatterns.Template.OrderProcessTemplate;
import BehavioralPatterns.Template.StoreOrder;
import org.junit.jupiter.api.Test;

public class TemplateTest {
    @Test
    public void testTemplate(){
        System.out.println("--- NetOrder instance of the Template:");
        OrderProcessTemplate netOrder = new NetOrder();
        netOrder.processOrder();
        System.out.println("--- StoreOrder instance of the Template:");
        OrderProcessTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder();
    }
}
