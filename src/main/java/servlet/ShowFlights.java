package servlet;

import Core.InputOutput.Printer.HTMLPirnter;
import service.TicketOffice.TicketOffice;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by employee on 10/29/15.
 */
public class ShowFlights extends HttpServlet {


    TicketOffice ticketOffice;
    HTMLPirnter printer;

    @Override
    public void init() throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        ticketOffice = ctx.getBean(TicketOffice.class);
        printer = ctx.getBean(HTMLPirnter.class);
    }

    /**
     * handles HTTP GET request
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String flightDescription = "<body style=\"text-align: center\">";
        flightDescription += printer.printFlight(ticketOffice.getAllFlights());

        String backBottom = "<p><form action=/ method=post>\n" +
                " <input type=\"submit\" value=\"Get to start\" />\n" +
                " </form></p>";

        PrintWriter writer = response.getWriter();
        writer.println("<html>" + flightDescription + backBottom + "</body>" + "</html>");
        writer.flush();
    }

    /**
     * handles HTTP POST request
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String cityName = request.getParameter("cityName");
        String flightDescription = "<body style=\"text-align: center\">";
        flightDescription += printer.printFlight(ticketOffice.searchFlightsByCity(cityName));
        String backBottom = "<form action=/ method=post>" +
                "<input type=\"submit\" value=\"Get to start\" />" +
                "</form>";
        flightDescription += backBottom + "</body>";
        PrintWriter writer = response.getWriter();
        writer.println("<html>" + flightDescription + "</html>");
        writer.flush();
    }
}
