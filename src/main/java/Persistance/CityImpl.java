package Persistance;

import Core.BaseDaoimpl;
import Core.CityDAO;

import Entity.City;

import java.util.List;

/**
 * Created by Oleg on 27.10.2015.
 */
public class CityImpl extends BaseDaoimpl implements CityDAO {


    public List<City> getAll() {
        return sessionFactory.getCurrentSession().createQuery("From City order by cityName").list();
    }


    public City getCityNameById(int id) {

        return (City) sessionFactory.getCurrentSession().createQuery("From City WHERE id_city='" + id + "'").list().get(0);
    }


    public City getCityIdByName(String cityName) {
        return (City) sessionFactory.getCurrentSession().createQuery("From City Where cityName Like '" + cityName + "'").list().get(0);
    }




}
