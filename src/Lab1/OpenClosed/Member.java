package Lab1.OpenClosed;

public class Member extends Passenger{
    private int yearsOfMembership;

    public Member(String name, int age, int years ) {
        super(name,age);
        yearsOfMembership = years;

    }

    @Override
    public double applyDiscount(double p) {
        if (yearsOfMembership > 5) {
            p = p / 2;
            return p;
        } else if (yearsOfMembership <= 5 && yearsOfMembership > 1) {
            p = (p *9)/10;
            return p;
        }
        return p;

    }
}
