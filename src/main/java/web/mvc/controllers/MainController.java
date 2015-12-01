package web.mvc.controllers;

import core.entity.City;
import core.entity.Flights;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/30/15.
 */

@RestController
@RequestMapping(value = "/angular")
public class MainController extends BaseController {

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public List<City> getCities() {
        return managerOffice.getAllCities();
    }

    @RequestMapping(value = "/flights", method = RequestMethod.GET)
    public List<Flights> getFlights() {
        return managerOffice.getAllFlights();
    }

    @RequestMapping(value = "/cities/add", method = RequestMethod.POST)
    public void addCity(@RequestBody String  cityName  ){
        City city = new City();
        city.setCityName(cityName);
        managerOffice.addCity(city);
    }

    @RequestMapping(value = "/cities/delete/{cityId}", method = RequestMethod.DELETE)
    public void deleteCity(@PathVariable("cityId") int cityId ){
        managerOffice.removeCity(managerOffice.getCityById(cityId));
    }



}
