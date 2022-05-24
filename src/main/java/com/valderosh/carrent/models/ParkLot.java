package com.valderosh.carrent.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class ParkLot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String location;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Cars carsBrands;

//    @Column
//    @ElementCollection(targetClass=String.class)
//    private List<String> autos;

    private String autos;

    private String avaliable;
    private String unavaliable;
    private int number_of_cars;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(String avaliable) {
        this.avaliable = avaliable;
    }

    public String getUnavaliable() {
        return unavaliable;
    }

    public void setUnavaliable(String unavaliable) {
        this.unavaliable = unavaliable;
    }

    public int getNumber_of_cars() {
        return number_of_cars;
    }

    public void setNumber_of_cars(int number_of_cars) {
        this.number_of_cars = number_of_cars;
    }

    public String getAutos() {
        return autos;
    }

    public void setAutos(String autos) {
        this.autos = autos;
    }

    public ParkLot(String location, String autos, String avaliable, String unavaliable, int number_of_cars) {
        this.location = location;
        this.autos = autos;
        this.avaliable = avaliable;
        this.unavaliable = unavaliable;
        this.number_of_cars = number_of_cars;
    }

    public ParkLot() {
    }


}
