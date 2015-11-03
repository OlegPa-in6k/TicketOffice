package servlet;

import Core.Entity.Flights;
import Persistance.FlightDaoImpl;
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
 * Created by employee on 11/2/15.
 */
public class DeleteFlight extends BaseServlet {



    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {


    /**
     * handles HTTP POST request
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
           throws IOException {

    }
}

