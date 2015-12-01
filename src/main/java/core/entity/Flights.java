package core.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import web.DateSerializer.JsonDateDeserializer;
import web.DateSerializer.JsonDateSerializer;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by employee on 10/26/15.
 */
@Entity
@Table(name = "Flights")
public class Flights {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


    @Id
    @GeneratedValue
    private int id;
    @Column(name = "EmptySeat")
    private int emptySeat;

    @Column(name = "departureDate")
    private Timestamp departureDate;


    @ManyToOne
    @JoinColumn(name = "id_city")
    private City city;


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;

    }

    public Flights() {
    }

    public Flights(int id,  int emtySeat, String date) {
        this.id = id;

        this.emptySeat = emtySeat;
        this.departureDate = Timestamp.valueOf(LocalDateTime.parse(date, FORMATTER));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDepartureDate() {
        return departureDate;
    }
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    public void setDepartureDate(String date) {
        this.departureDate = Timestamp.valueOf(LocalDateTime.parse(date, FORMATTER));
    }
    public void setDepartureDate(Timestamp date){
        this.departureDate=date;
    }

    public int getEmptySeat() {
        return emptySeat;
    }

    public void setEmptySeat(int emptySeat) {
        this.emptySeat = emptySeat;
    }

    public String toString() {

        return getCity().getCityName() + " " + getEmptySeat() + " " + getDepartureDate();

    }

    public boolean hasSeats(int seat){
        return getEmptySeat()>=seat;
    }






}