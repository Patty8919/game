package flight;

public class Appliction {
    public static void main(String[] args) {
        System.out.println(FlightSearch.searchArrivalAirport("Beijing"));
        System.out.println(FlightSearch.searchDepartureAirport("Warsaw"));
        System.out.println(FlightSearch.searchConnectingFlights("Warsaw", "London",
                "New York"));

    }
}