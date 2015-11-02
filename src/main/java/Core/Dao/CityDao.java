package Core.Dao;


import Core.Entity.City;

/**
 * Created by employee on 10/27/15.
 */
public interface CityDao extends BaseDao <City>{



    City getCityIdByName(String cityName);






}
