package web.mvc.controllers;

import core.service.AirManager.ManagerOffice;
import core.service.TicketOffice.TicketOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import persistance.CityDaoImpl;
import persistance.FlightDaoImpl;

/**
 * Created by employee on 11/5/15.
 */
@Controller
public class BaseController {

    @Autowired
    protected CityDaoImpl citySearch;
    @Autowired
    protected ManagerOffice managerOffice;
    @Autowired
    protected FlightDaoImpl flightSearch;
    @Autowired
    protected TicketOffice ticketOffice;

}
