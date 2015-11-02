package servlet;

import AirManager.ManagerOffice;
import Entity.Flights;
import Persistance.CityImpl;
import Persistance.FlightImpl;
import TicketOffice.TicketOffice;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by employee on 10/30/15.
 */
public class BuyTicket extends HttpServlet {

    FlightImpl flightSearch;
    CityImpl citySearch;
    TicketOffice ticketOffice;

    @Override
    public void init() throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        flightSearch = ctx.getBean(FlightImpl.class);
        citySearch = ctx.getBean(CityImpl.class);
        ticketOffice = ctx.getBean(TicketOffice.class);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String emptyseats = request.getParameter("seatCount");
        int seatCount = Integer.parseInt(emptyseats);

        String flightId = request.getParameter("Id");
        int id = Integer.parseInt(flightId);
        Flights flights=flightSearch.getFlightByID(id);
        String a;
        if(flights.getEmptySeat()>=seatCount){
            ticketOffice.setSeat(id,seatCount);
            a="U succsesfully buy tickets";
        } else{
            a = "Oops, NO such count of tickets";
        }

        String bottom = "<form action=/ method=post>" +
                "<input type=\"submit\" value=\"Get to start\" />" +
                "</form>";

        PrintWriter writer = response.getWriter();
        writer.println("<html>"+a+bottom+"</html>");
        writer.flush();
    }

    /**
     * handles HTTP POST request
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String flightId = request.getParameter("Id");
        int id = Integer.parseInt(flightId);
        Flights flight = flightSearch.getFlightByID(id);

        String flightDescription = "<body><form ><table border =1>" +
                "<tr><td>DepartureCity</td>"+
                "<td>Empty Seats</td>"+
                "<td>Departure date</td></tr>"+
                "<tr><td>" + flight.getCity().getCityName() + "</td>" +
                "<td>" + flight.getEmptySeat() + "</td>" +
                "<td>" + flight.getDepartureDate() + "</td>" +
                "<td>" + "<label>\n" +
                "CounterOfSeats:\n" +
                "<input type=\"text\" size=\"5\" name=\"seatCount\"/>\n" +
                "</label>" + "</td>" +
                "<td>" + "<input type=\"submit\" name=\"Id\"  value=\""+flight.getId()+"\" />" + "</td></tr></table></form>";


        PrintWriter writer = response.getWriter();
        writer.println("<html>" + flightDescription + "</html>");
        writer.flush();

    }
}
