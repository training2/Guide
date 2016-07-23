package com.training2.guide.models;

/**
 * Created by Kirill on 19.07.2016.
 */
public class Station {

    private int id;
    private City city;
    private String street;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
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
        return "Station:" +
                "id=" + id +
                ", city Id=" + city  +
                ", street=" + street;
    }
}
