package com.valderosh.carrent.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class ParkLot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String phoneNumber;
    private String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ParkLot() {
    }

    public ParkLot(String phoneNumber, String location) {
        this.phoneNumber = phoneNumber;
        this.location = location;
    }
}
