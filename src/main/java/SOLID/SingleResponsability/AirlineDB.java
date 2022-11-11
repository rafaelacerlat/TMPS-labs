package Lab1.SingleResponsability;

import java.util.ArrayList;
import java.util.List;

public class AirlineDB {

    List<Flight> flights = new ArrayList<>();

    public void addFlight( Flight flight){
        flights.add(flight);
    }

    public void displayAvailableFlights(String origin, String destination) {
        int size, seats;
        boolean flag = true;
        String o, d;
        size = flights.size();
        for (int i = 0; i < size; i++) {
            o = flights.get(i).getOrigin();
            d = flights.get(i).getDestination();
            seats = flights.get(i).getNumberOfSeatsleft();
            if ((o.equals(origin) == true) && (d.equals(destination) == true) && seats > 0) {
                if (flag == true) {
                    System.out.println("List of available flights:");
                    flag = false;
                }
                System.out.println(flights.get(i));
            }
        }
        if (flag == true) {
            System.out.println("no available flights");
        }
    }
}
