package StructuralPatterns.Project2.Bridge;

public class Crossover extends Car {
    public Crossover(Combustible combustible){
        super(combustible);
    }

    @Override
    public void getCarDetails() {
        System.out.println("This crossover car has configuration for: ");
        combustible.hasCombustible();
    }
}
