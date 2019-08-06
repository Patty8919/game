package flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightSearch {
    public static List<Flight> searchDepartureAirport(String departCity) {
        return FlightList.getFlightList().stream().filter(f -> f.getDepartureCity().equals(departCity))
                .collect(Collectors.toList());
    }

    public static List<Flight> searchArrivalAirport(String arrivalCity) {
        return FlightList.getFlightList().stream().filter(f -> f.getArrivalCity().equals(arrivalCity))
                .collect(Collectors.toList());
    }

    public static List<Flight> searchConnectingFlights(String departCity, String connectingCity, String arrivalCity) {
        List<Flight> result = FlightList.getFlightList().stream()
                .filter(f -> (f.getDepartureCity().equals(departCity)) && (f.getArrivalCity().equals(connectingCity)))
                .collect(Collectors.toList());

        result.addAll(FlightList.getFlightList().stream()
                .filter(f -> f.getDepartureCity().equals(connectingCity) && f.getArrivalCity().equals(arrivalCity))
        .collect(Collectors.toList()));

        return result;
    }
}
