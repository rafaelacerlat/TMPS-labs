package BehavioralPatterns;

import BehavioralPatterns.Observer.ProductSubject;
import org.junit.jupiter.api.Test;

public class ObserverTest {

    @Test
    public void testObserver() {
        Product laptop = new Product("A001", "Notebook", 999);
        ProductSubject productSubject = new ProductSubject(laptop.getPid());

        User user1 = new User("U001", "Emma");
        User user2 = new User("U002", "John");

        productSubject.addObserver(user1);
        productSubject.addObserver(user2);

        productSubject.notifyObservers(laptop, 899);
    }
}
