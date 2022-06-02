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

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "park_id")
//    private ParkLot location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Cars car;

    private String firstname;
    private String lastname;
    private String phone_number;
    private String passport_data;
    private String age;
    private String driver_exp;
    private String time, cost;
    private Date created_at, expire_date;

    //Constructor
    public Contracts() {
    }


    //String location, this.car_model = car_model; String car_model, ParkLot location,
    public Contracts(User orendator, Cars car, String firstname, String lastname, String phone_number, String passport_data,  String age, String driver_exp,  String time, String cost, Date created_at, Date expire_date) {
        //Relation
        this.orendator = orendator;
//        this.location = location;
        this.car = car;
        //Static
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone_number = phone_number;
        this.passport_data = passport_data;
        this.age = age;
        this.driver_exp = driver_exp;
        this.time = time;
        this.cost = cost;
        this.created_at = created_at;
        this.expire_date = expire_date;

    }

    //GeTSet Methods
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

//    public ParkLot getLocation() {
//        return location;
//    }
//
//    public void setLocation(ParkLot location) {
//        this.location = location;
//    }

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars car) {
        this.car = car;
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
}
