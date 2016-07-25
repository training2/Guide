/**
 * This class PassangerPath
 * @author Kirill Bugrim on 20.07.2016.
 * @version 1.1
 */

package com.training2.guide.models;

public class PassangerPath {

    private int id;
    private Passanger passanger;
    private Station stationFrom;
    private Station stationTo;

    public PassangerPath() {
    }

    public Passanger getPassanger() {
        return passanger;
    }

    public void setPassanger(Passanger passanger) {
        this.passanger = passanger;
    }

    public Station getStationFrom() {
        return stationFrom;
    }

    public void setStationFrom(Station stationFrom) {
        this.stationFrom = stationFrom;
    }

    public Station getStationTo() {
        return stationTo;
    }

    public void setStationTo(Station stationTo) {
        this.stationTo = stationTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PassangerPath{" +
                "id=" + id +
                ", passanger=" + passanger +
                ", stationFrom=" + stationFrom +
                ", stationTo=" + stationTo +
                '}';
    }
}
