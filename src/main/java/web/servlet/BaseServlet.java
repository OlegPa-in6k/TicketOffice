package web.servlet;


import Persistance.CityDaoImpl;
import Persistance.FlightDaoImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import Core.service.AirManager.ManagerOffice;
import Core.service.TicketOffice.TicketOffice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by employee on 11/3/15.
 */
public class BaseServlet extends HttpServlet {
    protected TicketOffice ticketOffice;
    protected ManagerOffice managerOffice;
    protected FlightDaoImpl flightSearch;
    protected CityDaoImpl citySearch;

    @Override
    public void init() throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        ticketOffice = ctx.getBean(TicketOffice.class);
        managerOffice = ctx.getBean(ManagerOffice.class);
        flightSearch = ctx.getBean(FlightDaoImpl.class);
        citySearch = ctx.getBean(CityDaoImpl.class);
    }

}
