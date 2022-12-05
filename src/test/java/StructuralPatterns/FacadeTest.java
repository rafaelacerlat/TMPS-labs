package StructuralPatterns;

import StructuralPatterns.Project2.Facade.CarFacade;
import org.junit.jupiter.api.Test;

public class FacadeTest {
    @Test
    public void testFacade(){
        CarFacade carFacade = new CarFacade();
        carFacade.createCar();
    }
}
