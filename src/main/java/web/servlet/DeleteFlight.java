package web.servlet;

import core.entity.Flights;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by employee on 11/2/15.
 */
@WebServlet(urlPatterns = "/DeleteFlight")
public class DeleteFlight extends BaseServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("flights", flightSearch.getAll());
        req.getRequestDispatcher("views/DeleteFlight.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String flightId = req.getParameter("flightId");
        int id = Integer.parseInt(flightId);
        Flights flight = flightSearch.read(id);
        flightSearch.delete(flight);
        PrintWriter writer = resp.getWriter();
        writer.println("<html>" + "Flight Was Added" + "<body>" +
                " <form action=/ >\n" +
                " <input type=\"submit\" value=\"Get to start\" />\n" +
                " </form></body>" + "</html>");

        writer.flush();
    }
}

