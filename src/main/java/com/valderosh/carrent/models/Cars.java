package com.valderosh.carrent.models;

import javax.persistence.*;

@Entity
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String car_brand;
    private String car_model;
    private String car_segment;
    private String car_colour;
    private String car_power;
    private String car_drive_opt;
    private String car_status;
    private String car_fuel;
    private String car_transmission;
    private String car_image;


//    @OneToOne(mappedBy = "carModel", fetch = FetchType.EAGER)
//    private Prices price;

    public String getMin_value_per_hour() {
        return min_value_per_hour;
    }

    public void setMin_value_per_hour(String min_value_per_hour) {
        this.min_value_per_hour = min_value_per_hour;
    }

    private String min_value_per_hour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getCar_segment() {
        return car_segment;
    }

    public void setCar_segment(String car_segment) {
        this.car_segment = car_segment;
    }

    public String getCar_colour() {
        return car_colour;
    }

    public void setCar_colour(String car_colour) {
        this.car_colour = car_colour;
    }

    public String getCar_power() {
        return car_power;
    }

    public void setCar_power(String car_power) {
        this.car_power = car_power;
    }

    public String getCar_drive_opt() {
        return car_drive_opt;
    }

    public void setCar_drive_opt(String car_drive_opt) {
        this.car_drive_opt = car_drive_opt;
    }

    public String getCar_status() {
        return car_status;
    }

    public void setCar_status(String car_status) {
        this.car_status = car_status;
    }

    public String getCar_fuel() {
        return car_fuel;
    }

    public void setCar_fuel(String car_fuel) {
        this.car_fuel = car_fuel;
    }

    public String getCar_transmission() {
        return car_transmission;
    }

    public void setCar_transmission(String car_transmission) {
        this.car_transmission = car_transmission;
    }

    public String getCar_image() {
        return car_image;
    }

    public void setCar_image(String car_image) {
        this.car_image = car_image;
    }


    public Cars() {
    }




    public Cars(String car_brand, String car_model, String car_segment, String car_colour, String car_power, String car_drive_opt, String car_status, String car_fuel, String car_transmission, String car_image, String min_value_per_hour) {
        this.car_brand = car_brand;
        this.car_model = car_model;
        this.car_segment = car_segment;
        this.car_colour = car_colour;
        this.car_power = car_power;
        this.car_drive_opt = car_drive_opt;
        this.car_status = car_status;
        this.car_fuel = car_fuel;
        this.car_transmission = car_transmission;
        this.car_image = car_image;
        this.min_value_per_hour = min_value_per_hour;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", car_brand='" + car_brand + '\'' +
                ", car_model='" + car_model + '\'' +
                ", car_segment='" + car_segment + '\'' +
                ", car_colour='" + car_colour + '\'' +
                ", car_power='" + car_power + '\'' +
                ", car_drive_opt='" + car_drive_opt + '\'' +
                ", car_status='" + car_status + '\'' +
                ", car_fuel='" + car_fuel + '\'' +
                ", car_transmission='" + car_transmission + '\'' +
                ", car_image='" + car_image + '\'' +
                ", min_value_per_hour='" + min_value_per_hour + '\'' +
                '}';
    }
}
