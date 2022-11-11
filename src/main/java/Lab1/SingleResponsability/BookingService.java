package Lab1.SingleResponsability;

import Lab1.OpenClosed.Passenger;

import java.util.ArrayList;
import java.util.List;

public class BookingService {

    List<Flight> flights;
    List<Ticket> tickets;

    BookingService (AirlineDB database) {
        this.flights = database.flights;
        this.tickets = new ArrayList<>();
    }


    public void bookSeat(int flightNumber, Passenger p) {
        int size = flights.size();
        boolean flag = false;
        int index = 0, seats;
        for (int i = 0; i < size; i++) {
            if (flights.get(i).getFlightNumber() == flightNumber) {
                flag = true;
                index = i;
                break;
            }

        }
        double price;
        seats = flights.get(index).getNumberOfSeatsleft();
        if (flag == true && (seats > 0)) {
            flights.get(index).bookASeat();
            price = p.applyDiscount(flights.get(index).getPrice());
            Ticket a = new Ticket(flights.get(index), p, price);
            tickets.add(a);
            System.out.println("you have succesfully booked a seat for flight " + flightNumber);
            System.out.println("ticket: " + a);


        } else {
            if (flag == true && seats == 0) {
                System.out.println("The Flight " + flightNumber + " is full you cannot book a ticket for this flight");

            } else if (flag == false) {
                System.out.println("The Flight " + flightNumber + " cdoes not exist");
            }
        }

    }
}
