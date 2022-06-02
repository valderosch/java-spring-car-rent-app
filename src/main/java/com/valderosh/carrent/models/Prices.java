package com.valderosh.carrent.models;
import javax.persistence.*;

@Entity
public class Prices {
    // Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Relations
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cars_id")
    private Cars cars;

    //integers
    private int per_hour, one_day, seven_days, thirty_days;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cars getCars() {
        return cars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }

    public int getPer_hour() {
        return per_hour;
    }

    public void setPer_hour(int per_hour) {
        this.per_hour = per_hour;
    }

    public int getOne_day() {
        return one_day;
    }

    public void setOne_day(int one_day) {
        this.one_day = one_day;
    }

    public int getSeven_days() {
        return seven_days;
    }

    public void setSeven_days(int seven_days) {
        this.seven_days = seven_days;
    }

    public int getThirty_days() {
        return thirty_days;
    }

    public void setThirty_days(int thirty_days) {
        this.thirty_days = thirty_days;
    }

    //Constructor
    public Prices() {
    }

    public Prices(Cars cars, int per_hour, int one_day, int seven_days, int thirty_days) {
        this.cars = cars;
        this.per_hour = per_hour;
        this.one_day = one_day;
        this.seven_days = seven_days;
        this.thirty_days = thirty_days;
    }
}
