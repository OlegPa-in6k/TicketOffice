package Persistance;

import Core.Dao.FlightDAO;
import Core.Entity.Flights;
import org.hibernate.Query;

import java.sql.Timestamp;
import java.util.List;


/**
 * Created by employee on 10/26/15.
 */
public class FlightDaoImpl extends BaseDaoImpl<Flights> implements FlightDAO {

    public FlightDaoImpl() {
        super();
    }


    @SuppressWarnings("Uncheked")
    public List<Flights> getFlightsByCity(int cityId) {
        Query query = startSession().createQuery("FROM Flights WHERE  id_city = :idCity");
        query.setParameter("idCity", cityId);

        return query.list();
    }


    public List<Flights> getFlightByDate(Timestamp date) {
        Query query = startSession().createQuery("FROM Flights WHERE departureDate = :date");
        query.setParameter("date", date);
        return query.list();
    }


    public Flights getFlight(int cityId, Timestamp date) {
        Query query = startSession().createQuery("FROM Flights WHERE " +
                "id_city = :idCity  AND departureDate = :date");
        query.setParameter("idCity", cityId);
        query.setParameter("date", date);

        return (Flights) query.uniqueResult();
    }


}
