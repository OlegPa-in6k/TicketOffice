package web.mvc.controllers;


import core.entity.Flights;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by employee on 11/4/15.
 */
@Controller
public class TicketOffices extends BaseController {




    @RequestMapping(value = "/ticketOffice" ,method = RequestMethod.GET)
    public String getCities(ModelMap modelMap) {
        modelMap.addAttribute("cities", citySearch.getAll());
        return "ticketOffice";
    }
    @RequestMapping(value = "/ticketOffice/flights", method = RequestMethod.GET)
    public String getFlights(ModelMap modelMap) {
        modelMap.addAttribute("flights", ticketOffice.getAllFlights());
        return "flights";
    }
    @RequestMapping(value = "/ticketOffice/flights/", method = RequestMethod.POST)
    public String getFlightsByCity(@RequestParam("cityName") String cityName, ModelMap modelMap) {


        modelMap.addAttribute("flights", ticketOffice.searchFlightsByCity(cityName));
        return "flights";
    }

    @RequestMapping(value = "/ticketOffice/buyTicket", method = RequestMethod.GET)
    public String selectSeats(@RequestParam("flightId") String flightId, ModelMap modelMap) {

        modelMap.addAttribute("flight", flightSearch.read(Integer.parseInt(flightId)));

        return "buyTicket";
    }

    @RequestMapping(value = "/ticketOffice/buyTicket", method = RequestMethod.POST)
    public String editContact(ModelMap modelMap,
                              @RequestParam("flightId") String flightId,
                              @RequestParam("seatCount") String seatCount) {
        int id = Integer.parseInt(flightId);
        int seats = Integer.parseInt(seatCount);
        Flights flights = flightSearch.read(id);
        String answer;
        if(flights.hasSeats(seats)){
            answer = "bought";
        ticketOffice.setSeat(id, seats);
        } else answer ="falseCount";
        modelMap.addAttribute("flightId", flightId);
        return answer;
    }






}
