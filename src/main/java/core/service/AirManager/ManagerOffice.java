package core.service.AirManager;

import core.entity.City;
import core.entity.Flights;
import org.springframework.dao.DataIntegrityViolationException;
import persistance.CityDaoImpl;
import persistance.FlightDaoImpl;

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




    public void setNewFlight(int emptySeat, String ariivalCity, String date){

        Flights flight = new Flights();
        flight.setEmptySeat(emptySeat);
        flight.setDepartureDate(date);
        flight.setCity(citySearch.getCityIdByName(ariivalCity));

        flightSearch.create(flight);

    }

    public  void deleteFlight(Flights flights){


        flightSearch.delete(flights);
    }

    public void minusEmptySeat(Flights flights, int seat){
        flights.setEmptySeat(flights.getEmptySeat() - seat);
        flightSearch.update(flights);
    }

    public void addCity(City city){
        citySearch.create(city);
    }

    public void removeCity(City city){
        try{ citySearch.delete(city);
        } catch (DataIntegrityViolationException e){

        }
    }

    public void updateCity(City city){
        try{ citySearch.update(city);
        } catch (DataIntegrityViolationException e){

        }

    }
}
