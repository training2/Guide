package com.training2.guide.models;

/**
 * Created by Kirill on 19.07.2016.
 */
public class Address {
    private int id;
    private String city;
    private String street;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    @Override
    public String toString() {
        return "Address:" +
                "id=" + id +
                ", city Id=" + city  +
                ", street=" + street;
    }
}
