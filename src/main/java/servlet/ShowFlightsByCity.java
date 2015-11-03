package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by employee on 11/3/15.
 */
@WebServlet(urlPatterns = "/ShowFlightsByCity")

public class ShowFlightsByCity extends  BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String cityName = req.getParameter("cityName");

        req.setAttribute("flights", flightSearch.getFlightsByCity(citySearch.getCityIdByName(cityName).getCityId()));
        req.getRequestDispatcher("views/ShowFlightsByCity.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}
