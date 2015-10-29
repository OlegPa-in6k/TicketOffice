package servlet;

import Entity.Flights;
import InputController.InputController;
import Persistance.FlightImpl;
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

    /*FlightImpl flightSearch;*/
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            new String[]{"applicationContext.xml"}, true);


    FlightImpl flightSearch =  context.getBean(FlightImpl.class);


   /* @Override
    public void init() throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        flightSearch =  ctx.getBean(FlightImpl.class);
    }*/

    /**
     * handles HTTP GET request
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String s="<body><table>";
        for(Flights flight: flightSearch.getAll()){
            s+="<td><td>" + flight.toString() + "</td></tr>";

        }
        s+="</table></body>";

        PrintWriter writer = response.getWriter();
        writer.println("<html>" + s +"</html>");
        writer.flush();
    }

    /**
     * handles HTTP POST request
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String s="<body><table>";
        for(Flights flight: flightSearch.getAll()){
            s+="<td><td>" + flight.toString() + "</td></tr>";

        }
        s+="</table></body>";

        PrintWriter writer = response.getWriter();
        writer.println("<html>" + s + "</html>");
        writer.flush();

    }

    /**
     * this life-cycle method is invoked when the application or the server
     * is shutting down
     */
    public void destroy() {
        System.out.println("Servlet is being destroyed");
    }
}
