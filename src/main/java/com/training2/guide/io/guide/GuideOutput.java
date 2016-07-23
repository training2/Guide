package com.training2.guide.io.guide;

import com.training2.guide.algorithm.dijkstra.models.Node;
import com.training2.guide.algorithm.guide.GuideLogic;
import com.training2.guide.io.IOutput;
import com.training2.guide.io.guide.model.PathModel;
import com.training2.guide.models.AbstractTransport;
import com.training2.guide.models.Station;

import java.util.List;

public class GuideOutput implements IOutput {

    private PathModel pathModel;
    private GuideLogic logic;

    public GuideOutput(List<Node> nodeList) {
        this.logic = new GuideLogic(nodeList);
        this.pathModel = new PathModel(logic.getLogic(), nodeList);
    }

    @Override
    public void print() {
        Station station;
        AbstractTransport abstractTransport;
        if(pathModel.getAbstractTransportList().isEmpty()) {
            System.out.println("Get taxi");
            return;
        }
        for(int i = 0; i < pathModel.getAbstractTransportList().size(); i++) {
            station = pathModel.getStationList().get(i);
            abstractTransport = pathModel.getAbstractTransportList().get(i);
            System.out.print("On " + station.getId() + " " + station.getCity().getCityName() + ", " + station.getStreet() + " ");
            if(i != 0 && goesToNextStation(i)) {
                System.out.print("continue on " + abstractTransport.getId() + ", he goes to " + getNextAddress(i).getId() + " " +
                        getNextAddress(i).getCity().getCityName() + ", " + getNextAddress(i).getStreet());
                System.out.println();
                continue;
            }
            System.out.println("station get " + abstractTransport.getId() + ", he goes to " + getNextAddress(i).getId() + " " +
                    getNextAddress(i).getCity().getCityName() + ", " + getNextAddress(i).getStreet());
        }
        System.out.println("You have reached your destination");
    }

    private Station getNextAddress(int currentIndex) {
        if(currentIndex + 1 < pathModel.getStationList().size()) {
            return pathModel.getStationList().get(currentIndex + 1);
        }
        return pathModel.getStationList().get(currentIndex);
    }

    private boolean goesToNextStation(int currentIndex) {
        if(pathModel.getAbstractTransportList().get(currentIndex).getId() == pathModel.getAbstractTransportList()
                .get(currentIndex - 1).getId()) {
            return true;
        }
        return false;
    }
}
