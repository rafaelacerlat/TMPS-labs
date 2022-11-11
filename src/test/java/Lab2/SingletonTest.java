package test.java.Lab2;

import main.java.Lab2.Singleton.Singleton;
import org.junit.jupiter.api.Test;


class SingletonTest {

    @Test
    public void testSingleton() {
        Singleton singleton = Singleton.getInstance("Company 1");
    }

}