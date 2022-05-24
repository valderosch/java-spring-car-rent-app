package com.valderosh.carrent.models;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "car")
    private String price_carModel;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cars_id")
    private Cars carModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Cars getCar_model() {
        return  carModel;
    }

    public void setCar_model(Cars car_model) {
        this.carModel = car_model;
    }

    public String getPrice_carModel() {
        return price_carModel;
    }

    public void setPrice_carModel(String price_carModel) {
        this.price_carModel = price_carModel;
    }
    //integers

    private int per_hour, one_day, seven_days, thirty_days;
    //Constructor
    public Prices() {
    }

    public Prices(String price_carModel, int per_hour, int one_day, int seven_days, int thirty_days) {
        this.price_carModel = price_carModel;
//        this.carModel = car_model;
        this.per_hour = per_hour;
        this.one_day = one_day;
        this.seven_days = seven_days;
        this.thirty_days = thirty_days;
    }

    @Override
    public String toString() {
        return "\nPrices{" +
                "id=" + id +
                ", carModel=" + carModel +
                ", per_hour=" + per_hour +
                ", one_day=" + one_day +
                ", seven_days=" + seven_days +
                ", thirty_days=" + thirty_days +
                '}';
    }
}
