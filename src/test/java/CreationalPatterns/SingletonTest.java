package test.java.CreationalPatterns;

import main.java.CreationalPatterns.Singleton.Singleton;
import org.junit.jupiter.api.Test;


class SingletonTest {

    @Test
    public void testSingleton() {
        Singleton singleton = Singleton.getInstance("Company 1");
    }

}