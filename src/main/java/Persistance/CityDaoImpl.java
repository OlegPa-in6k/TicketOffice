package Persistance;

import Core.Dao.CityDao;

import Core.Entity.City;
import org.hibernate.Query;




/**
 * Created by Oleg on 27.10.2015.
 */
public class CityDaoImpl extends BaseDaoImpl<City> implements CityDao {


    public City getCityIdByName(String cityName) {
        Query query = startSession().createQuery("From City Where cityName Like :cityName");
        query.setParameter("cityName", cityName);
        return (City) query.uniqueResult();
    }




}
