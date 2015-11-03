package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by employee on 11/3/15.
 */
@WebServlet(urlPatterns = "/BuyTickets")
public class BuyTickets extends  BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

       /* int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("flight", flightSearch.read(id));*/
        req.getRequestDispatcher("views/BuyTickets.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String flightId = req.getParameter("flightId");
        String seatCount1 = req.getParameter("seatCount");
        int id = Integer.parseInt(flightId);
        int seatCount = Integer.parseInt(seatCount1);
        //req.setAttribute("flight", flightSearch.read(id));
        System.out.println(id);

    }
}
