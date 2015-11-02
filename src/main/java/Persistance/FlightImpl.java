package Persistance;

import Core.BaseDaoimpl;
import Core.FlightDAO;
import Entity.Flights;
import org.hibernate.Query;

import java.sql.Timestamp;
import java.util.List;


/**
 * Created by employee on 10/26/15.
 */
public class FlightImpl extends BaseDaoimpl implements FlightDAO {


    @Override
    public List<Flights> getAll() {

        return startSession().createQuery("FROM Flights order by departureDate").list();
    }

    public Flights getFlightByID(int id){
        Query query = startSession().createQuery("From Flights Where id = :id");
        query.setParameter("id", id);
        return (Flights) query.uniqueResult();

    }

    @SuppressWarnings("Uncheked")
    public List<Flights> getFlightsByCity(int idCity) {
        Query query = startSession().createQuery("FROM Flights WHERE  id_city = :idCity");
        query.setParameter("idCity", idCity);

        return query.list();
    }


    public List<Flights> getFlightByDate(Timestamp date) {
        Query query = startSession().createQuery("FROM Flights WHERE departureDate = :date");
        query.setParameter("date", date);
        return query.list();
    }


    public Flights getFlight(int idCity, Timestamp date) {
        Query query = startSession().createQuery("FROM Flights WHERE " +
                "id_city = :idCity  AND departureDate = :date");
        query.setParameter("idCity", idCity);
        query.setParameter("date", date);

        return (Flights) query.uniqueResult();
    }



}
