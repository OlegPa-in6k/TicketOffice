package Core;

import java.util.List;

/**
 * Created by employee on 10/27/15.
 */
public interface CityDAO<City> {

    City getCityNameById(int id);

    City getCityIdByName(String cityName);

    List<City> getAll();



}
