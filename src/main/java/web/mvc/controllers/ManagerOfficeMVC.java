package web.mvc.controllers;


import core.entity.City;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by employee on 11/4/15.
 */
@Controller
public class ManagerOfficeMVC extends BaseController{


    @RequestMapping(value = "/managerOffice" ,method = RequestMethod.GET)
    public String getManagerOffice() {
        return "managerOffice";
    }
    @RequestMapping(value = "/managerOffice/addFlight", method = RequestMethod.GET)
    public String addFlight(ModelMap modelMap){
        modelMap.addAttribute("cities", citySearch.getAll());
        modelMap.addAttribute("flights", flightSearch.getAll());
        return "addFlight";
    }
    @RequestMapping(value = "flights/addFlight", method = RequestMethod.POST)
    public String addNewFlight(@RequestParam("seatCount") String seatCount,
                               @RequestParam("cityName") String arrivalCity,
                               @RequestParam("departureDate") String departureDate, ModelMap modelMap){
        int seat = Integer.parseInt(seatCount);


        managerOffice.setNewFlight(seat, arrivalCity, departureDate);

        modelMap.addAttribute("cities", citySearch.getAll());
        modelMap.addAttribute("flights", flightSearch.getAll());
        return "addFlight";
    }
    @RequestMapping(value = "/flights/delete", method = RequestMethod.GET)
    public String DeleteFlight(ModelMap modelMap){
        modelMap.addAttribute("flights", flightSearch.getAll());
        return "deleteFlight";
    }

    //Don't WORK!!!!!!!!
    @RequestMapping(value = "/flights/delete", method = RequestMethod.POST)
    public String DelFlight(@RequestParam("flightId") String flightId,
            ModelMap modelMap){
        int id = Integer.parseInt(flightId);
        managerOffice.deleteFlight(flightSearch.read(id));
        modelMap.addAttribute("flights", flightSearch.getAll());
        return "deleteFlight";
    }

    @RequestMapping(value = "/managerOffice/city", method = RequestMethod.GET)
    public String ShowCity(ModelMap modelMap){
        modelMap.addAttribute("cities", citySearch.getAll());
        return "city";
    }

    @RequestMapping(value = "/managerOffice/city/delete", method = RequestMethod.GET)
    public String DeleteCity(
            @RequestParam("id") String cityId,
            ModelMap modelMap){
        int id = Integer.parseInt(cityId);

        citySearch.delete(citySearch.read(id));

        modelMap.addAttribute("cities", citySearch.getAll());
        return "city";
    }
    @RequestMapping(value = "/managerOffice/cities/add", method = RequestMethod.POST)
    public String AddCity(
            @RequestParam("cityName") String cityName,
            ModelMap modelMap){
        City city = new City();
        city.setCityName(cityName);
        citySearch.create(city);
        modelMap.addAttribute("cities", citySearch.getAll());
        return "city";
    }


    @RequestMapping(value = "managerOffice/city/update", method = RequestMethod.GET)
    public String ShowCity(
            @RequestParam("id") String cityId,
            ModelMap modelMap){
        modelMap.addAttribute("city", citySearch.read(Integer.parseInt(cityId)));
        return "cityUpdate";
    }
    @RequestMapping(value = "managerOffice/city/update", method = RequestMethod.POST)
    public String EditCity(
            @RequestParam("id") String cityId,
            ModelMap modelMap,
            @RequestParam("cityName") String cityName){
        City city = citySearch.read(Integer.parseInt(cityId));
        city.setCityName(cityName);
        citySearch.update(city);
        modelMap.addAttribute("cities", citySearch.getAll());
        return "city";
    }




}
