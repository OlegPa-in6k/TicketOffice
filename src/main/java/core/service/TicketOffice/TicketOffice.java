package core.service.TicketOffice;

import core.entity.City;
import core.entity.Flights;
import org.springframework.stereotype.Service;
import persistance.CityDaoImpl;
import persistance.FlightDaoImpl;
import core.inputOutput.Printer.PrinterImpl;
import org.hibernate.exception.SQLGrammarException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by employee on 10/29/15.
 */
@Service
public class TicketOffice {
    public FlightDaoImpl flightSearch;
    public CityDaoImpl citySearch;
    PrinterImpl printer;

    public TicketOffice(CityDaoImpl citySearch, FlightDaoImpl flightSearch) {
        this.citySearch = citySearch;
        this.flightSearch = flightSearch;

    }

    public List<Flights> getAllFlights()
    {
        return flightSearch.getAll();
    }

    public List<Flights> searchFlightsByCity(String arrivalCity){

        return flightSearch.getFlightsByCity(citySearch.getCityIdByName(arrivalCity).getCityId());
    }
    public List<Flights> searchFlightsByDate(String departureDate){
        Timestamp departureDate1 = Timestamp.valueOf(LocalDateTime.parse(departureDate, Flights.FORMATTER));
        return flightSearch.getFlightByDate(departureDate1);
    }
    public boolean hasSeat(String arrivalCity, String departureDate, int seatCount){
        boolean answer = false;
        int cityId = citySearch.getCityIdByName(arrivalCity).getCityId();
        Timestamp departureDate1= Timestamp.valueOf(LocalDateTime.parse(departureDate, Flights.FORMATTER));
        try {
            Flights flight = flightSearch.getFlight(cityId, departureDate1);
            printer.printFlight(flight);

            answer = flight.getEmptySeat() >= seatCount;

        } catch(SQLGrammarException e){
            answer = false;
        }
        return answer;
    }

    public void setSeat(int id, int seat){
        Flights flight = (Flights) flightSearch.read(id);
        if(seat<=flight.getEmptySeat()){
            flight.setEmptySeat(flight.getEmptySeat()-seat);
        }
        flightSearch.update(flight);
    }

    public Flights getFlightById(int id){
        return flightSearch.read(id);
    }

    public List<City> getAllCitites(){
        return citySearch.getAll();
    }


}
