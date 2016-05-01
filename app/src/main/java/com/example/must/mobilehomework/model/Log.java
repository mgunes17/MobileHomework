package com.example.must.mobilehomework.model;

/**
 * Created by must on 01.05.2016.
 */
public class Log {
    private String pickupCity;
    private String dropoffCity;
    private User user;
    private Car car;
    private RentDate date;

    public Log(){
        //dosyaya aynen yazdır
    }

    public RentDate getDate() {
        return date;
    }

    public void setDate(RentDate date) {
        this.date = date;
    }

    public String getDropoffCity() {
        return dropoffCity;
    }

    public void setDropoffCity(String dropoffCity) {
        this.dropoffCity = dropoffCity;
    }

    public String getPickupCity() {
        return pickupCity;
    }

    public void setPickupCity(String pickupCity) {
        this.pickupCity = pickupCity;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
