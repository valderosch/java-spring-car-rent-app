package com.valderosh.carrent.models;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class Contracts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User orendator;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "park_id")
    private ParkLot parklocation;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Cars carModel;

    private String car;
    private String location;
    private String firstname;
    private String lastname;
    private String phone_number;
    private String passport_data;
    private String age;
    private String driver_exp;
    private String car_model, time, cost;
    private Date created_at, expire_date;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassport_data() {
        return passport_data;
    }

    public void setPassport_data(String passport_data) {
        this.passport_data = passport_data;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDriver_exp() {
        return driver_exp;
    }

    public void setDriver_exp(String driver_exp) {
        this.driver_exp = driver_exp;
    }


    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }



//    public ParkLot getParklocation() {
//        return parklocation;
//    }
//
//    public void setParklocation(ParkLot parklocation) {
//        this.parklocation = parklocation;
//    }





    public Contracts() {
    }



    public String getUserName(){
        return orendator != null ? orendator.getUsername() : "<None>";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOrendator() {
        return orendator;
    }

    public void setOrendator(User orendator) {
        this.orendator = orendator;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public ParkLot getParklocation() {
        return parklocation;
    }

    public void setParklocation(ParkLot parklocation) {
        this.parklocation = parklocation;
    }

    //String location, this.car_model = car_model; String car_model,
    public Contracts(User orendator, String location, String car, String firstname, String lastname, String phone_number, String passport_data,  String age, String driver_exp,  String time, String cost, Date created_at, Date expire_date) {
        this.orendator = orendator;
        this.location = location;
        this.car = car;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone_number = phone_number;
        this.passport_data = passport_data;
        this.age = age;
        this.driver_exp = driver_exp;
        //User Info

        this.time = time;
        this.cost = cost;
        this.created_at = created_at;
        this.expire_date = expire_date;

    }
}
