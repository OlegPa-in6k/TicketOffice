package console.Printer;

import core.entity.Flights;

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
        for (Flights flight : list) {
            html += "<form action=/TicketOffice/BuyTicket method=post>";
            html += "<tr><td>" + flight.getCity().getCityName() + "</td>";
            html += "<td>" + flight.getEmptySeat() + "</td>";
            html += "<td>" + flight.getDepartureDate() + "</td>";
            html += "<td>" + "<input type=\"submit\" name=\"Id\"" +
                    "value=\"" + flight.getId() + "\" />" + "</td></tr></form>";

        }
        html+="</table>";
        return html;
    }


}
