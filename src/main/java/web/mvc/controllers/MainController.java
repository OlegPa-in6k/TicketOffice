package web.mvc.controllers;

import core.entity.City;
import core.entity.Flights;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/30/15.
 */

@RestController
@RequestMapping(value = "/api")
public class MainController extends BaseController {

    @RequestMapping(value = "/")
    public String[] index() {

        return new String[] {"first", "second", "qwer"};
    }

    @RequestMapping(value = "/cities")
    public List<City> getCities() {

        return managerOffice.getAllCities();
    }

    @RequestMapping(value = "/flights")
    public List<Flights> getFlights() {
        return managerOffice.getAllFlights();
    }

}
