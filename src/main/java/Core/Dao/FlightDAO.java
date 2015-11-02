package Core.Dao;




import Core.Entity.Flights;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
public interface FlightDAO extends BaseDao<Flights> {


    List<Flights> getFlightsByCity(int cityId);

    List<Flights> getFlightByDate(Timestamp date);

    Flights getFlight(int cityId, Timestamp date);








}
