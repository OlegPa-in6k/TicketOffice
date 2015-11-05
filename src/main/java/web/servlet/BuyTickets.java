package web.servlet;

import core.entity.Flights;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by employee on 11/3/15.
 */
@WebServlet(urlPatterns = "/BuyTickets")
public class BuyTickets extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("flightId", id);
        req.getRequestDispatcher("views/BuyTickets.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String flightId = req.getParameter("flightId");
        String seatCount1 = req.getParameter("seatCount");
        int id = Integer.parseInt(flightId);
        int seatCount = Integer.parseInt(seatCount1);
        Flights flight = flightSearch.read(id);
        String answer = "";
        if (flight.hasSeats(seatCount)) {
            ticketOffice.setSeat(id, seatCount);
            answer = "U bought " + seatCount + " ticket!";
        } else answer = "No such count of Ticket";
        PrintWriter writer = resp.getWriter();
        writer.println("<html>" + answer + "<body>" +
                " <form action=/ >\n" +
                " <input type=\"submit\" value=\"Get to start\" />\n" +
                " </form></body>" + "</html>");

        writer.flush();

    }
}
