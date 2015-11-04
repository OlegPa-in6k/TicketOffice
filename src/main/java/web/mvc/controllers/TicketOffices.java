package web.mvc.controllers;


import Core.service.TicketOffice.TicketOffice;
import Persistance.CityDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by employee on 11/4/15.
 */
@Controller
public class TicketOffices {

    @Autowired
    private CityDaoImpl citySearch;
    @Autowired
    private TicketOffice ticketOffice;
    @Autowired
    private CityDaoImpl city;


    @RequestMapping(value = "/ticketOffice" ,method = RequestMethod.GET)
    public String getCities(ModelMap modelMap) {
        modelMap.addAttribute("cities", citySearch.getAll());
        return "ticketOffice";
    }
    @RequestMapping(value = "/flights", method = RequestMethod.GET)
    public String getFlights(ModelMap modelMap) {
        modelMap.addAttribute("flights", ticketOffice.getAllFlights());
        return "flights";
    }
    @RequestMapping(value = "/flights/{cityName}", method = RequestMethod.POST)
    public String getFlightsByCity(@PathVariable String cityName, ModelMap modelMap) {
        modelMap.addAttribute("flights", ticketOffice.searchFlightsByCity(cityName));
        return "flights";
    }

   /* @RequestMapping(value = "/buyTicket", method = RequestMethod.POST)
    public String buyTicket(ModelMap modelMap) {
        modelMap.addAttribute("flights", ticketOffice.getAllFlights());
        return "flights";
    }*/






}
