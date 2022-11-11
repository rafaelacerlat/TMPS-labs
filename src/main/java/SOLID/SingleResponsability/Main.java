package Lab1.SingleResponsability;

import Lab1.OpenClosed.Member;
import Lab1.OpenClosed.NonMember;
import Lab1.OpenClosed.Passenger;

public class Main {
    public static void main(String[] args) {
        Flight f1 = new Flight(1602, "Los Angeles", "New York", "4:30pm", 200, 192.5);
        Flight f2 = new Flight(3982, "Frankfurt", "London", "12:45pm",194, 108.35);

        AirlineDB database = new AirlineDB();
        database.addFlight(f1);
        database.addFlight(f2);



        Passenger p1 = new Member("Emily", 26, 4);
        Passenger p2 = new NonMember("Sam", 67);

        database.displayAvailableFlights("Los Angeles", "New York");

        BookingService bookingService = new BookingService(database);
        bookingService.bookSeat(1602, p1);
    }

}
