package Core;



import java.sql.Timestamp;
import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
public interface FlightDAO<Flights>  {


    List<Flights> getFlightsByCity(int id_city);

    List<Flights> getFlightByDate(Timestamp date);

    Flights getFlight(int id_city, Timestamp date);








}
