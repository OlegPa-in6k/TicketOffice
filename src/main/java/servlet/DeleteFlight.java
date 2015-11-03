package servlet;

import Core.Entity.Flights;
import Persistance.FlightDaoImpl;
import service.TicketOffice.TicketOffice;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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


        req.getRequestDispatcher("views/TicketOffice.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}

