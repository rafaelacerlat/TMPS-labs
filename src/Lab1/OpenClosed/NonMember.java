package Lab1.OpenClosed;

public class NonMember extends Passenger{

    public NonMember(String name, int age) {
        super(name, age);
    }

    @Override
    public double applyDiscount(double p) {
        if (age > 65) {
            p = (p *9)/10;
            return p;
        }
        return p;
    }
}
