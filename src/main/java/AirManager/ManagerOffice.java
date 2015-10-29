package AirManager;

import Entity.Flights;
import Persistance.CityImpl;
import Persistance.FlightImpl;


import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by employee on 10/28/15.
 */
public class ManagerOffice {
    FlightImpl flightSearch;
    CityImpl citySearch;

    public ManagerOffice(FlightImpl flightSearch, CityImpl citySearch){
        this.flightSearch = flightSearch;
        this.citySearch = citySearch;
    }



    public void setNewFlight(int emptySeat, String ariivalCity, String departureDate){

        Flights flight = new Flights();
        flight.setEmptySeat(emptySeat);
        flight.setDepartureDate(departureDate);
        flight.setCity(citySearch.getCityIdByName(ariivalCity));

        flightSearch.save(flight);

    }

    public  void deleteFlight(String  arrivalCity, String departureDate){
        Timestamp date = Timestamp.valueOf(LocalDateTime.parse(departureDate, Flights.FORMATTER));
        Flights flight = flightSearch.getFlight(citySearch.getCityIdByName(arrivalCity).getCityId(), date);
        flightSearch.delete(flight);
    }

    public void minusEmptySeat(Flights flights, int seat){
        flights.setEmptySeat(flights.getEmptySeat() -seat);
        flightSearch.update(flights);
    }
}
