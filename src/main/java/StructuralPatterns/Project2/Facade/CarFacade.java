package StructuralPatterns.Project2.Facade;

public class CarFacade {
    private CarEngine engine = new CarEngine();
    private CarBody body = new CarBody();

    public CarFacade(){}

    public void createCar(){
        System.out.println("Creating a car ...");
        engine.setCarEngine();
        body.setCarBody();
        System.out.println("The car is ready!");
    }
}
