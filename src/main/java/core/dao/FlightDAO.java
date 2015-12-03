package core.dao;




import core.entity.Flights;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
@Repository
public interface FlightDAO extends BaseDao<Flights> {


    List<Flights> getFlightsByCity(int cityId);

    List<Flights> getFlightByDate(Timestamp date);

    Flights getFlight(int cityId, Timestamp date);








}
