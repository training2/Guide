package com.training2.guide.io.guide;

import com.training2.guide.algorithm.dijkstra.models.Node;
import com.training2.guide.algorithm.guide.GuideLogic;
import com.training2.guide.dao.jdbc.TransportDAO;
import com.training2.guide.exceptions.TransportNotFoundException;
import com.training2.guide.io.guide.model.PathModel;
import com.training2.guide.models.AbstractTransport;
import com.training2.guide.models.Station;
import java.util.List;

/**
 * This class build the result
 * @author rutkovba
 */
public abstract class AbstractOutput {

    private PathModel pathModel;
    private GuideLogic logic;
    private TransportDAO dao;

    public AbstractOutput(List<Node> nodeList) throws TransportNotFoundException {
        this.logic = new GuideLogic(nodeList);
        this.pathModel = new PathModel(logic.getLogic(), nodeList);
        this.dao = new TransportDAO();
    }

    /**
     * Result build method
     * @return
     */
    protected StringBuilder prepareOut() {
        StringBuilder out = new StringBuilder();
        Station station;
        AbstractTransport abstractTransport;
        if(pathModel.getAbstractTransportList().isEmpty()) {
            out.append("\n");
            out.append("Get taxi");
            out.append("\n");
            return out;
        }
        for(int i = 0; i < pathModel.getAbstractTransportList().size(); i++) {
            station = pathModel.getStationList().get(i);
            abstractTransport = pathModel.getAbstractTransportList().get(i);
            String transportType = dao.getTypeTransport(abstractTransport.getId());
            out.append("\n");
            out.append("On " + station.getId() + " " + station.getCity().getCityName() + ", " + station.getStreet() + " ");
            if(i != 0 && goesToNextStation(i)) {
                out.append("continue on " + abstractTransport.getId() + " " + transportType + ", it goes to "
                        + getNextAddress(i).getId() + " " + getNextAddress(i).getCity().getCityName() + ", "
                        + getNextAddress(i).getStreet());
                continue;
            }
            out.append("station get " + abstractTransport.getId() + " " + transportType + ", it goes to "
                    + getNextAddress(i).getId() + " " + getNextAddress(i).getCity().getCityName() + ", "
                    + getNextAddress(i).getStreet());
        }
        out.append("\n");
        out.append("You have reached your destination");
        out.append("\n");
        return out;
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
