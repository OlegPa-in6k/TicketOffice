package core.dao;


import core.entity.City;
import org.springframework.stereotype.Repository;

/**
 * Created by employee on 10/27/15.
 */
@Repository
public interface CityDao extends BaseDao <City>{



    City getCityIdByName(String cityName);






}
