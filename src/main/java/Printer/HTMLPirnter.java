package Printer;

import Entity.Flights;
import Persistance.FlightImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by employee on 10/29/15.
 */
public class HTMLPirnter {
    HttpServletResponse response;
    PrintWriter printer;

    public HTMLPirnter(HttpServletResponse response) throws IOException {
        this.response = response;
        this.printer = response.getWriter();
    }

    public void showAllFlights() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"}, true);


        FlightImpl flightSearch =  context.getBean(FlightImpl.class);

        String s="<body><table>";
        for(Flights flight: flightSearch.getAll()){
            s+="<tr><td>" + flight.toString() + "</td></tr>";

        }
        s+="</table></body>";




        printer.println("<html>" + s +"</html>");
        printer.flush();
    }
}
