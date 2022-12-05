package StructuralPatterns;


import StructuralPatterns.Project2.Bridge.*;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    @Test
    public void testBridge(){
        Car sportsCar = new SportsCar(new Diesel());
        sportsCar.getCarDetails();

        Car crossover = new Crossover(new Battery());
        crossover.getCarDetails();

    }
}
