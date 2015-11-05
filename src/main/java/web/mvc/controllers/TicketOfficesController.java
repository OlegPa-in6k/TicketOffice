package web.mvc.controllers;

import core.entity.Flights;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by employee on 11/4/15.
 */
@Controller
@RequestMapping(value = "/ticketOffice")
public class TicketOfficesController extends BaseController {


    @RequestMapping( method = RequestMethod.GET)
    public String getCities(ModelMap modelMap) {
        modelMap.addAttribute("cities", ticketOffice.getAllCitites());
        modelMap.addAttribute("flights", ticketOffice.getAllFlights());
        return "ticketOffice2";
    }

    @RequestMapping(value = "/flights", method = RequestMethod.GET)
    public String getFlights(ModelMap modelMap) {
        modelMap.addAttribute("flights", ticketOffice.getAllFlights());
        return "flights";
    }

    @RequestMapping(value = "/flights/", method = RequestMethod.POST)
    public String getFlightsByCity(@RequestParam("cityName") String cityName, ModelMap modelMap) {


        modelMap.addAttribute("flights", ticketOffice.searchFlightsByCity(cityName));
        return "flights";
    }

    @RequestMapping(value = "/buyTicket/{flightId}", method = RequestMethod.GET)
    public String selectSeats(@PathVariable String flightId, ModelMap modelMap) {
        modelMap.addAttribute("flight", ticketOffice.getFlightById(Integer.parseInt(flightId)));
        return "buyTicket";
    }

    @RequestMapping(value = "/buyTicket/{flightId}", method = RequestMethod.POST)
    public String editContact(ModelMap modelMap,
                              @PathVariable int flightId,
                              @RequestParam("seatCount") int seatCount) {

        Flights flights = ticketOffice.getFlightById(flightId);
        String answer;
        if (flights.hasSeats(seatCount)) {
            answer = "bought";
            ticketOffice.setSeat(flightId, seatCount);
        } else answer = "falseCount";
        modelMap.addAttribute("flightId", flightId);
        return answer;
    }

    @RequestMapping(value = "/flights/{cityName}", method = RequestMethod.GET)
    public String getFlightsByCity1(@PathVariable String cityName, ModelMap modelMap) {

        modelMap.addAttribute("cities", ticketOffice.getAllCitites());
        modelMap.addAttribute("flights", ticketOffice.searchFlightsByCity(cityName));
        return "ticketOffice2";
    }


}
