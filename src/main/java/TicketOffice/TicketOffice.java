package TicketOffice;

import Entity.Flights;
import Persistance.CityImpl;
import Persistance.FlightImpl;
import Printer.PrinterImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by employee on 10/29/15.
 */
public class TicketOffice {
    public FlightImpl implFlight;
    public CityImpl implCity;
    PrinterImpl printer;

    public TicketOffice(CityImpl implCity, FlightImpl implFlight) {
        this.implCity = implCity;
        this.implFlight = implFlight;

    }

    public List<Flights> getAllFlights()
    {
        return implFlight.getAll();
    }

    public List<Flights> searchFlightsByCity(String arrivalCity){

        return implFlight.getFlightsByCity(implCity.getCityIdByName(arrivalCity).getCityId());
    }
    public List<Flights> searchFlightsByDate(String departureDate){
        Timestamp departureDate1 = Timestamp.valueOf(LocalDateTime.parse(departureDate, Flights.FORMATTER));
        return implFlight.getFlightByDate(departureDate1);
    }
    public boolean hasSeat(String arrivalCity, String departureDate, int seatCount){
        boolean answer = false;
        int cityId = implCity.getCityIdByName(arrivalCity).getCityId();
        Timestamp departureDate1= Timestamp.valueOf(LocalDateTime.parse(departureDate, Flights.FORMATTER));
        try {
            Flights flight = implFlight.getFlight(cityId, departureDate1);
            printer.printFlight(flight);

            answer = flight.getEmptySeat() >= seatCount;

        } catch(Exception e){
            answer = false;
        }
        return answer;
    }


}
