package Persistance;

import Core.BaseDaoimpl;
import Core.CityDAO;

import Entity.City;
import org.hibernate.Query;


import java.util.List;

/**
 * Created by Oleg on 27.10.2015.
 */
public class CityImpl extends BaseDaoimpl implements CityDAO {


    public List<City> getAll() {
        return startSession().createQuery("From City order by cityName").list();
    }


    public City getCityNameById(int id) {
        Query query = startSession().createQuery("From City WHERE id_city=:id");
        query.setParameter("id",id);

        return (City) query.uniqueResult();
    }


    public City getCityIdByName(String cityName) {
        Query query = startSession().createQuery("From City Where cityName Like :cityName");
        query.setParameter("cityName", cityName);
        return (City) query.uniqueResult();
    }




}
