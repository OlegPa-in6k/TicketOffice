package web.mvc.controllers;

import core.entity.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by employee on 11/5/15.
 */
@Controller
@RequestMapping(value = "/cities")
public class CityController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String ShowCity(ModelMap modelMap) {
        modelMap.addAttribute("cities", managerOffice.getAllCities());
        return "city";
    }

    @RequestMapping(value = "/delete/{cityId}", method = RequestMethod.DELETE)
    public String DeleteCity(
            @PathVariable int cityId,
            ModelMap modelMap) {


        managerOffice.removeCity(managerOffice.getCityById(cityId));

        modelMap.addAttribute("cities", managerOffice.getAllCities());
        return "city";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String AddCity(
            @RequestParam String cityName,
            ModelMap modelMap) {
        City city = new City();
        city.setCityName(cityName);
        managerOffice.addCity(city);
        modelMap.addAttribute("cities", managerOffice.getAllCities());
        return "city";
    }


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String ShowCity(
            @RequestParam String id,
            ModelMap modelMap) {
        modelMap.addAttribute("city", managerOffice.getCityById(Integer.parseInt(id)));
        return "cityUpdate";
    }

    @RequestMapping(value = "/update/{cityId}", method = RequestMethod.PATCH)
    public String EditCity(
            @PathVariable int cityId,
            ModelMap modelMap,
            @RequestParam String cityName) {
        City city = managerOffice.getCityById(cityId);
        city.setCityName(cityName);
        managerOffice.updateCity(city);
        modelMap.addAttribute("cities", managerOffice.getAllCities());
        return "city";
    }

}
