/**
 * This class City
 * @author Kirill Bugrim on 20.07.2016.
 * @version 1.1
 */

package com.training2.guide.models;

public class City {

    private int id;
    private String cityName;

    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
