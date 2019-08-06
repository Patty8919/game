package flight;

import java.util.ArrayList;
import java.util.List;

public class FlightList {

    public static List<Flight> getFlightList() {
        List<Flight> flightList = new ArrayList<>();
        flightList.add(new Flight("Warsaw", "London"));
        flightList.add(new Flight("London", "New York"));
        flightList.add(new Flight("Oslo", "Moscow"));
        flightList.add(new Flight("Moscow", "Beijing"));
        flightList.add(new Flight("London", "Beijing"));
        flightList.add(new Flight("Beijing", "Delhi"));
        return new ArrayList<>(flightList);
    }
}
