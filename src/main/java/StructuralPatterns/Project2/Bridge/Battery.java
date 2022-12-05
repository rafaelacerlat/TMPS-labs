package StructuralPatterns.Project2.Bridge;

public class Battery implements Combustible{

    @Override
    public void hasCombustible() {
        System.out.println("electricity");
    }
}
