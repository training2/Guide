package com.training2.guide.models;


import java.util.ArrayList;
import java.util.List;

public class Transport {

    private int id;
    private String transportType;

    private List<Station> stationList;


    {
        stationList =new ArrayList<Station>();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public List<Station> getStationList() {
        return stationList;
    }

    public void setStationList(List<Station> stationList) {
        this.stationList = stationList;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    @Override
    public String toString() {
        return "Transport" +
                " id=" + id +
                ", stationList=" + stationList +
                '\n';
    }
}
