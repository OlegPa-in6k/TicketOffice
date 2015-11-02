package servlet;

import AirManager.ManagerOffice;
import Entity.Flights;
import Persistance.CityImpl;
import Persistance.FlightImpl;
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
public class AddNewFlight extends HttpServlet {


    FlightImpl flightSearch;
    CityImpl citySearch;

    @Override
    public void init() throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        flightSearch =  ctx.getBean(FlightImpl.class);
        citySearch =  ctx.getBean(CityImpl.class);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        PrintWriter writer = response.getWriter();
        writer.println("<html>Hello, I am a Java servlet!</html>");
        writer.flush();
    }

    /**
     * handles HTTP POST request
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String cityName = request.getParameter("cityName");

        String seatCount1 = request.getParameter("seatCount");
        int seatCount = Integer.parseInt(seatCount1);

        String departureDate = request.getParameter("departureDate");

        ManagerOffice office = new ManagerOffice(flightSearch,citySearch);
        office.setNewFlight(seatCount,cityName,departureDate);


        PrintWriter writer = response.getWriter();
        writer.println("<html>" + "Flight Was added" + "<body>" +
                " <form action=/ >\n" +
                " <input type=\"submit\" value=\"Get to start\" />\n" +
                " </form></body>" +"</html>");
        writer.flush();

    }
}
