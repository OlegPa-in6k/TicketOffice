package web.mvc.controllers;


import core.entity.City;


import org.springframework.dao.DataIntegrityViolationException;
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
@RequestMapping(value = "/managerOffice")
public class ManagerOfficeController extends BaseController {


    @RequestMapping( method = RequestMethod.GET)
    public String getManagerOffice() {
        return "managerOffice";
    }

    @RequestMapping(value = "/flights", method = RequestMethod.GET)
    public String addFlight(ModelMap modelMap) {
        modelMap.addAttribute("cities", managerOffice.getAllCities());
        modelMap.addAttribute("flights", managerOffice.getAllFlights());
        return "addFlight";
    }

    @RequestMapping(value = "/flights/new", method = RequestMethod.POST)
    public String addNewFlight(@RequestParam String seatCount,
                               @RequestParam String cityName,
                               @RequestParam String departureDate, ModelMap modelMap) {
        int seat = Integer.parseInt(seatCount);
        managerOffice.setNewFlight(seat, cityName, departureDate);
        modelMap.addAttribute("cities", managerOffice.getAllCities());
        modelMap.addAttribute("flights", managerOffice.getAllFlights());
        return "addFlight";
    }

    @RequestMapping(value = "/flights/delete", method = RequestMethod.GET)
    public String DeleteFlight(ModelMap modelMap) {
        modelMap.addAttribute("flights", managerOffice.getAllFlights());
        return "deleteFlight";
    }


    @RequestMapping(value = "/flights/delete/{flightId}", method = RequestMethod.DELETE)
    public String DelFlight(@PathVariable String flightId,
                            ModelMap modelMap) {
        int id = Integer.parseInt(flightId);
        managerOffice.deleteFlight(managerOffice.getFlightByid(id));
        modelMap.addAttribute("flights", managerOffice.getAllFlights());
        return "deleteFlight";
    }



}
