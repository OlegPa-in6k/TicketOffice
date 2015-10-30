package Persistance;

import Core.BaseDaoimpl;
import Core.FlightDAO;
import Entity.Flights;

import java.sql.Timestamp;
import java.util.List;


/**
 * Created by employee on 10/26/15.
 */
public class FlightImpl extends BaseDaoimpl implements FlightDAO {


    @Override
    public List<Flights> getAll() {

        return sessionFactory.getCurrentSession().createQuery("FROM Flights").list();
    }


    public List<Flights> getFlightsByCity(int id_city) {
        return sessionFactory.getCurrentSession().createQuery(
                "FROM Flights WHERE  id_city ='" + id_city + "'").list();
    }


    public List<Flights> getFlightByDate(Timestamp date) {
        return sessionFactory.getCurrentSession().createQuery(
                "FROM Flights WHERE departureDate ='" + date + "'").list();
    }


    public Flights getFlight(int id_city, Timestamp date) {


        return (Flights) sessionFactory.getCurrentSession().createQuery("FROM Flights WHERE " +
                "id_city = '" + id_city + "' AND departureDate = '" + date + "'").list().get(0);
    }



}
