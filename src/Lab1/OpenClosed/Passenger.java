package Lab1.OpenClosed;

public abstract class Passenger {

    String name;
    int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;

    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    abstract public double applyDiscount(double p);
}
