/**
 * This class abstract of Transport
 * @author Kirill Bugrim on 20.07.2016.
 * @version 1.1
 */
package com.training2.guide.models;
import java.util.List;

public abstract class AbstractTransport {

    private int id;
    private int transportNumber;
    private List<Station> stationList;

    public AbstractTransport() {
    }

    protected abstract void ride();

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getTransportNumber() {
        return transportNumber;
    }

    public void setTransportNumber(int transportNumber) {
        this.transportNumber = transportNumber;
    }

    public List<Station> getStationList() {
        return stationList;
    }

    public void setStationList(List<Station> stationList) {
        this.stationList = stationList;
    }
}
