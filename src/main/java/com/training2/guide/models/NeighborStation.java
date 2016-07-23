package com.training2.guide.models;

public class NeighborStation {

    private Station station;
    private Station neighborStation;
    private Integer distance;

    public NeighborStation() {
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Station getNeighborStation() {
        return neighborStation;
    }

    public void setNeighborStation(Station neighborStation) {
        this.neighborStation = neighborStation;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
