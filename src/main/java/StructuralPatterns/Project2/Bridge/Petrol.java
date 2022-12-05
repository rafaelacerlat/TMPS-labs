package StructuralPatterns.Project2.Bridge;

public class Petrol implements Combustible{

    @Override
    public void hasCombustible() {
        System.out.println("petrol");
    }
}
