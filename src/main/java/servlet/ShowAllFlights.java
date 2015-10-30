package servlet;

import Entity.Flights;
import InputController.InputController;
import Persistance.FlightImpl;
import Printer.HTMLPirnter;
import TicketOffice.TicketOffice;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by employee on 10/29/15.
 */
public class ShowAllFlights extends HttpServlet {

    FlightImpl flightSearch;
    TicketOffice ticketOffice;

    @Override
    public void init() throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        ticketOffice =  ctx.getBean(TicketOffice.class);

    }

    /**
     * handles HTTP GET request
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String s="<body><table>";
        for(Flights flight: ticketOffice.getAllFlights()){
            s+="<td><td>" + flight.toString() + "</td></tr>";

        }
        String bottom =" <form action=/ method=post>\n" +
                " <input type=\"submit\" value=\"Get to start\" />\n" +
                " </form>";

        s+=bottom + "</table></body>";

        PrintWriter writer = response.getWriter();
        writer.println("<html>" + s + "</html>");
        writer.flush();
    }

    /**
     * handles HTTP POST request
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String cityName = request.getParameter("cityName");
        String buyBottom =" <form action=/TicketOffice/BuyTicket method=post>\n" +
                " <input type=\"submit\" value=\"Buy Ticket\" />\n" +
                " </form>";
        String s="<body><table border = 1>";
        for(Flights flight: ticketOffice.searchFlightsByCity(cityName)){
            s+="<tr><td>" + flight.getCity().getCityName() + "</td>" +
                    "<td>"+ flight.getEmptySeat()+ " </td>" +
                    "<td>" + flight.getDepartureDate()+"</td>" +
                    " <td>" + buyBottom +"</td></tr>";
        }

        String bottom =" <form action=/ method=post>\n" +
                " <input type=\"submit\" value=\"Get to start\" />\n" +
                " </form>";

        s+=bottom + "</table></body>";

        PrintWriter writer = response.getWriter();
        writer.println("<html>" + s + "</html>");
        writer.flush();


    }

   /* *//**
     * this life-cycle method is invoked when the application or the server
     * is shutting down
     *//*
    public void destroy() {
        System.out.println("Servlet is being destroyed");
    }*/
}
