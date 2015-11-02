package Core.Entity;

import javax.persistence.*;

/**
 * Created by Oleg on 27.10.2015.
 */
@Entity
@Table(name = "City")
public class City {


    @Id
    @GeneratedValue
    @Column(name = "id_city")
    private int cityId;


    @Column(name = "cityName")
    private String cityName;


    public City() {}

    public City(int id, String cityName) {
        this.cityId = id;
        this.cityName = cityName;
    }


    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
