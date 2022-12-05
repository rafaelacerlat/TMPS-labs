package StructuralPatterns.Project2.Bridge;

public class SportsCar extends Car {
    public SportsCar(Combustible combustible){
        super(combustible);
    }

    @Override
    public void getCarDetails() {
        System.out.println("This sports car has configuration for: ");
        combustible.hasCombustible();
    }
}
