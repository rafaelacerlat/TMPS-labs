package StructuralPatterns.Project2.Bridge;

public abstract class Car {
    protected Combustible combustible;

    public Car(Combustible combustible){
        this.combustible = combustible;

    }

    public abstract void getCarDetails();
}
