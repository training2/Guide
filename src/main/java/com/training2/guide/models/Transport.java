package com.training2.guide.models;


import java.util.ArrayList;
import java.util.List;

public class Transport {

    private int id;
    private String transportType;

    private List<Address> addressList;


    {
        addressList=new ArrayList<Address>();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
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
                ", addressList=" + addressList +
                '\n';
    }
}
