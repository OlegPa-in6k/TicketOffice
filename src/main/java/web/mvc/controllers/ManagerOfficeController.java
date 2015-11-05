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

    @RequestMapping(value = "/addFlight", method = RequestMethod.GET)
    public String addFlight(ModelMap modelMap) {
        modelMap.addAttribute("cities", managerOffice.getAllCities());
        modelMap.addAttribute("flights", managerOffice.getAllFlights());
        return "addFlight";
    }

    @RequestMapping(value = "/addFlight/new", method = RequestMethod.POST)
    public String addNewFlight(@RequestParam String seatCount,
                               @RequestParam("cityName") String arrivalCity,
                               @RequestParam String departureDate, ModelMap modelMap) {
        int seat = Integer.parseInt(seatCount);

        managerOffice.setNewFlight(seat, arrivalCity, departureDate);

        modelMap.addAttribute("cities", managerOffice.getAllCities());
        modelMap.addAttribute("flights", managerOffice.getAllFlights());
        return "addFlight";
    }

    @RequestMapping(value = "/flights/delete", method = RequestMethod.GET)
    public String DeleteFlight(ModelMap modelMap) {
        modelMap.addAttribute("flights", managerOffice.getAllFlights());
        return "deleteFlight";
    }


    @RequestMapping(value = "/flights/delete/{flightId}", method = RequestMethod.POST)
    public String DelFlight(@PathVariable String flightId,
                            ModelMap modelMap) {
        int id = Integer.parseInt(flightId);
        managerOffice.deleteFlight(managerOffice.getFlightByid(id));
        modelMap.addAttribute("flights", managerOffice.getAllFlights());
        return "deleteFlight";
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public String ShowCity(ModelMap modelMap) {
        modelMap.addAttribute("cities", managerOffice.getAllCities());
        return "city";
    }

    @RequestMapping(value = "/city/delete/{cityId}", method = RequestMethod.POST)
    public String DeleteCity(
            @PathVariable int cityId,
            ModelMap modelMap) {


        managerOffice.removeCity(managerOffice.getCityById(cityId));

        modelMap.addAttribute("cities", managerOffice.getAllCities());
        return "city";
    }

    @RequestMapping(value = "/cities/add", method = RequestMethod.POST)
    public String AddCity(
            @RequestParam("cityName") String cityName,
            ModelMap modelMap) {
        City city = new City();
        city.setCityName(cityName);
        managerOffice.addCity(city);
        modelMap.addAttribute("cities", managerOffice.getAllCities());
        return "city";
    }


    @RequestMapping(value = "/city/update", method = RequestMethod.GET)
    public String ShowCity(
            @RequestParam("id") String cityId,
            ModelMap modelMap) {
        modelMap.addAttribute("city", managerOffice.getCityById(Integer.parseInt(cityId)));
        return "cityUpdate";
    }

    @RequestMapping(value = "/city/update/{cityId}", method = RequestMethod.POST)
    public String EditCity(
            @PathVariable String cityId,
            ModelMap modelMap,
            @RequestParam("cityName") String cityName) {
        City city = managerOffice.getCityById(Integer.parseInt(cityId));
        city.setCityName(cityName);
        managerOffice.updateCity(city);
        modelMap.addAttribute("cities", managerOffice.getAllCities());
        return "redirect:city";
    }


}
