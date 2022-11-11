package Lab1.OpenClosed;

public class Main {

    public static void main(String[] args) {
        Passenger p1 = new Member("Emily", 26, 4);
        System.out.println("The plane ticket price for " + p1.name + " after discount is: " + p1.applyDiscount(113));

        Passenger p2 = new NonMember("Sam", 67);
        System.out.println("The plane ticket price for " + p2.name + " after discount is: " + p2.applyDiscount(150));

    }

}
