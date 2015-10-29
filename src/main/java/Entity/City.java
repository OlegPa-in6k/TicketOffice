package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 27.10.2015.
 */
@Entity
@Table(name = "City")
public class City {


    @Id
    @GeneratedValue
    @Column(name = "id_city")
    private int id_city;


    @Column(name = "cityName")
    private String cityName;


    public City() {}

    public City(int id, String cityName) {
        this.id_city = id;
        this.cityName = cityName;
    }


    public int getCityId() {
        return id_city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
