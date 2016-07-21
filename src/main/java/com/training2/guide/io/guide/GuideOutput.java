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
        Address address = null;
        Transport transport = null;
        for(int i = 0; i < addressList.size(); i++) {
            address = addressList.get(i);
            transport = transportList.get(i);
            System.out.println(address.getId() + " " + address.getCity() + " " + address.getStreet() + " " +
            transport.getId() + " " + transport.getTransportType());
        }
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
