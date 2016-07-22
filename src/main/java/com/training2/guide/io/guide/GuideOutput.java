package com.training2.guide.io.guide;

import com.training2.guide.algorithm.dijkstra.models.Node;
import com.training2.guide.io.IOutput;
import com.training2.guide.models.Address;
import com.training2.guide.jdbc.dao.AbstractDao;
import com.training2.guide.jdbc.dao.AddressDAO;
import com.training2.guide.models.Transport;
import java.util.ArrayList;
import java.util.List;

public class GuideOutput implements IOutput {

    private List<Transport> transportList;
    private List<Address> addressList;
    private AbstractDao<Address, Integer> dao;

    public GuideOutput(List<Transport> transportList, List<Node> nodeList) {
        this.transportList = transportList;
        this.addressList = nodeToAddress(nodeList);
    }

    @Override
    public void print() {
        Address address;
        Transport transport;
        if(transportList.isEmpty()) {
            System.out.println("Get taxi");
            return;
        }
        for(int i = 0; i < transportList.size(); i++) {
            address = addressList.get(i);
            transport = transportList.get(i);
            System.out.print("On " + address.getId() + " " + address.getCity() + " " + address.getStreet() + " ");
            if(i != 0 && goesToNextStation(i)) {
                System.out.print("continue on " + transport.getId() + " " + transport.getTransportType() + ", he goes to " + getNextAddress(i).getId() + " " +
                        getNextAddress(i).getCity() + " " + getNextAddress(i).getStreet());
                System.out.println();
                continue;
            }
            System.out.println("station get " + transport.getId() + " " + transport.getTransportType() + ", he goes to " + getNextAddress(i).getId() + " " +
                    getNextAddress(i).getCity() + " " + getNextAddress(i).getStreet());
        }
        System.out.println("You have reached your destination");
    }

    private Address getNextAddress(int currentIndex) {
        if(currentIndex + 1 < addressList.size()) {
            return addressList.get(currentIndex + 1);
        }
        return addressList.get(currentIndex);
    }

    private boolean goesToNextStation(int currentIndex) {
        if(transportList.get(currentIndex).getId() == transportList.get(currentIndex - 1).getId()) {
            return true;
        }
        return false;
    }

    private List<Address> nodeToAddress(List<Node> nodeList) {
        List<Address> addressList = new ArrayList<>();
        this.dao = new AddressDAO();
        for(Node node: nodeList) {
            addressList.add(dao.getById(node.getId()));
        }
        return addressList;
    }
}
