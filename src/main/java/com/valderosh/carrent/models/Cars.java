package com.valderosh.carrent.models;

import javax.persistence.*;

@Entity
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //Fields
    private String brand;
    private String mark;
    private String segment;
    private String colour;
    private String power;
    private String drive_opt;
    private String status;
    private String fuel;
    private String transmission;
    private String image;
    private String number;

    //Relations
    @OneToOne(mappedBy = "cars", fetch = FetchType.EAGER)
    private Prices prices;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="park_id")
    private ParkLot location;

    //Constructor
    public Cars() {
    }

    public Cars(String brand, String mark, String segment, String colour, String power, String drive_opt, String status, String fuel, String transmission, String image, String number, ParkLot location) {
        this.brand = brand;
        this.mark = mark;
        this.segment = segment;
        this.colour = colour;
        this.power = power;
        this.drive_opt = drive_opt;
        this.status = status;
        this.fuel = fuel;
        this.transmission = transmission;
        this.image = image;
        this.number = number;
        this.location = location;
    }

    //GetSetters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDrive_opt() {
        return drive_opt;
    }

    public void setDrive_opt(String drive_opt) {
        this.drive_opt = drive_opt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    public ParkLot getLocation() {
        return location;
    }

    public void setLocation(ParkLot location) {
        this.location = location;
    }

}
