package controllers;

import Persistance.FlightDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.TicketOffice.TicketOffice;

/**
 * Created by employee on 11/4/15.
 */
@Controller
@RequestMapping(value = "/ShowAllFlights")
public class Aeroport {

    @Autowired
    private TicketOffice ticketOffice;

    @RequestMapping(method = RequestMethod.GET)
    public String getDre(ModelMap modelMap) {
        modelMap.addAttribute("flights", ticketOffice.getAllFlights());
        return "flights";
    }
}
