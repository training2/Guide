package com.training2.guide.io.guide;

import com.training2.guide.algorithm.dijkstra.models.Node;
import com.training2.guide.io.IOutput;
import com.training2.guide.models.Station;
import com.training2.guide.dao.AbstractDao;
import com.training2.guide.dao.AddressDAO;
import com.training2.guide.models.Transport;
import java.util.ArrayList;
import java.util.List;

public class GuideOutput implements IOutput {

    private List<Transport> transportList;
    private List<Station> stationList;
    private AbstractDao<Station, Integer> dao;

    public GuideOutput(List<Transport> transportList, List<Node> nodeList) {
        this.transportList = transportList;
        this.stationList = nodeToAddress(nodeList);
    }

    @Override
    public void print() {
        Station station;
        Transport transport;
        if(transportList.isEmpty()) {
            System.out.println("Get taxi");
            return;
        }
        for(int i = 0; i < transportList.size(); i++) {
            station = stationList.get(i);
            transport = transportList.get(i);
            System.out.print("On " + station.getId() + " " + station.getCity() + " " + station.getStreet() + " ");
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

    private Station getNextAddress(int currentIndex) {
        if(currentIndex + 1 < stationList.size()) {
            return stationList.get(currentIndex + 1);
        }
        return stationList.get(currentIndex);
    }

    private boolean goesToNextStation(int currentIndex) {
        if(transportList.get(currentIndex).getId() == transportList.get(currentIndex - 1).getId()) {
            return true;
        }
        return false;
    }

    private List<Station> nodeToAddress(List<Node> nodeList) {
        List<Station> stationList = new ArrayList<>();
        this.dao = new AddressDAO();
        for(Node node: nodeList) {
            stationList.add(dao.getById(node.getId()));
        }
        return stationList;
    }
}
