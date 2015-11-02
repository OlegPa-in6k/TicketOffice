package Printer;

import AirManager.ManagerOffice;
import Entity.Flights;
import Persistance.FlightImpl;
import TicketOffice.TicketOffice;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by employee on 10/29/15.
 */
public class HTMLPirnter {


    public String printFlight(List<Flights> list){
        String html="<table border =1>";
        html+="<tr><td>DepartureCity</td>"+
                "<td>Empty Seats</td>"+
                "<td>Departure date</td></tr>";
        for(Flights flight: list){
            html+="<tr><td>" + flight.getCity().getCityName()+"</td>"+
                    "<td>" + flight.getEmptySeat() + "</td>"+
                    "<td>" + flight.getDepartureDate() + "</td>";
        }
        return html;
    }


}
