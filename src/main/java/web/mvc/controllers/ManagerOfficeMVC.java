package web.mvc.controllers;


import Core.service.AirManager.ManagerOffice;
import Persistance.CityDaoImpl;
import Persistance.FlightDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by employee on 11/4/15.
 */
@Controller
public class ManagerOfficeMVC {
    @Autowired
    private CityDaoImpl citySearch;
    @Autowired
    private ManagerOffice managerOffice;
    @Autowired
    private FlightDaoImpl flightSearch;

    @RequestMapping(value = "/managerOffice" ,method = RequestMethod.GET)
    public String getManagerOffice() {
        return "managerOffice";
    }
    @RequestMapping(value = "/addFlight", method = RequestMethod.GET)
    public String addFlight(ModelMap modelMap){
        modelMap.addAttribute("cities", citySearch.getAll());
        modelMap.addAttribute("flights", flightSearch.getAll());
        return "addFlight";
    }
    @RequestMapping(value = "/addFlight", method = RequestMethod.POST)
    public String addNewFlight(@RequestParam("seatCount") String seatCount,
                               @RequestParam("cityName") String arrivalCity,
                               @RequestParam("departureDate") String departureDate, ModelMap modelMap){
        int seat = Integer.parseInt(seatCount);
        managerOffice.setNewFlight(seat, arrivalCity, departureDate);

        modelMap.addAttribute("cities", citySearch.getAll());
        modelMap.addAttribute("flights", flightSearch.getAll());
        return "addFlight";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String DeleteFlight(ModelMap modelMap){
        modelMap.addAttribute("flights", flightSearch.getAll());
        return "delete";
    }

    //Don't WORK!!!!!!!!
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String DelFlight(@RequestParam("flightId") String flightId,
            ModelMap modelMap){
        modelMap.addAttribute("flights", flightSearch.getAll());
        int id = Integer.parseInt(flightId);

        managerOffice.deleteFlight(flightSearch.read(id));
        return "delete";
    }


}
