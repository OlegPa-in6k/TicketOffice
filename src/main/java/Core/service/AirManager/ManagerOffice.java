package Core.service.AirManager;

import Core.Entity.Flights;
import Persistance.CityDaoImpl;
import Persistance.FlightDaoImpl;

/**
 * Created by employee on 10/28/15.
 */
public class ManagerOffice {
    FlightDaoImpl flightSearch;
    CityDaoImpl citySearch;

    public ManagerOffice(FlightDaoImpl flightSearch, CityDaoImpl citySearch){
        this.flightSearch = flightSearch;
        this.citySearch = citySearch;
    }



    public void setNewFlight(int emptySeat, String ariivalCity, String departureDate){

        Flights flight = new Flights();
        flight.setEmptySeat(emptySeat);
        flight.setDepartureDate(departureDate);
        flight.setCity(citySearch.getCityIdByName(ariivalCity));

        flightSearch.create(flight);

    }

    public  void deleteFlight(int id){

        Flights flight = (Flights) flightSearch.read(id);
        flightSearch.delete(flight);
    }

    public void minusEmptySeat(Flights flights, int seat){
        flights.setEmptySeat(flights.getEmptySeat() - seat);
        flightSearch.update(flights);
    }
}
