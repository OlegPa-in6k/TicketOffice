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
 * Created by employee on 11/2/15.
 */
public class DeleteFlight extends HttpServlet {


    FlightImpl flightSearch;
    CityImpl citySearch;
    TicketOffice ticketOffice;

    @Override
    public void init() throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        flightSearch =  ctx.getBean(FlightImpl.class);
        citySearch =  ctx.getBean(CityImpl.class);
        ticketOffice = ctx.getBean(TicketOffice.class);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String flightId = request.getParameter("Id");
        flightSearch.delete(flightSearch.getFlightByID(Integer.parseInt(flightId)));

        String flightDescription = "<body style=\"text-align: center\"><table border=1>";
        flightDescription+="<tr><td>DepartureCity</td>"+
                "<td>Empty Seats</td>"+
                "<td>Departure date</td></tr>";

        for (Flights flight : ticketOffice.getAllFlights()) {
            flightDescription += "<form action=/ManagerOffice/DeleteFlight method=get>";
            flightDescription += "<tr><td>" + flight.getCity().getCityName() + "</td>";
            flightDescription += "<td>" + flight.getEmptySeat() + "</td>";
            flightDescription += "<td>" + flight.getDepartureDate() + "</td>";
            flightDescription += "<td>" + "<input type=\"submit\" name=\"Id\"" + "value=\"" + flight.getId() + "\" />" + "</td></tr></form>";


        }


        String bottom = " <form action=/ method=post>\n" +
                " <input type=\"submit\" value=\"Get to start\" />\n" +
                " </form>";

        PrintWriter writer = response.getWriter();
        writer.println("<html>"+flightDescription + bottom+"</html>");
        writer.flush();
    }

    /**
     * handles HTTP POST request
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String flightDescription = "<body style=\"text-align: center\"><table border=1>";

        for (Flights flight : ticketOffice.getAllFlights()) {
            flightDescription += "<form action=/ManagerOffice/DeleteFlight method=get>";
            flightDescription += "<tr><td>" + flight.getCity().getCityName() + "</td>";
            flightDescription += "<td>" + flight.getEmptySeat() + "</td>";
            flightDescription += "<td>" + flight.getDepartureDate() + "</td>";
            flightDescription += "<td>" + "<input type=\"submit\" name=\"Id\"" + "value=\"" + flight.getId() + "\" />" + "</td></tr></form>";


        }


        String bottom = " <form action=/ method=post>\n" +
                " <input type=\"submit\" value=\"Get to start\" />\n" +
                " </form>";


        PrintWriter writer = response.getWriter();
        writer.println("<html>" + flightDescription + bottom + "</table></body>" + "</html>");
        writer.flush();

    }
}

