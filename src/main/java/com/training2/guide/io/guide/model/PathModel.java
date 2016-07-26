package com.training2.guide.io.guide.model;

import com.training2.guide.algorithm.dijkstra.models.Node;
import com.training2.guide.dao.IStationDao;
import com.training2.guide.dao.jdbc.mysql.StationDAO;
import com.training2.guide.models.AbstractTransport;
import com.training2.guide.models.Station;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a model for out the result of guide algorithm
 * @author rutkovba
 */
public class PathModel {

    private IStationDao<Station, Integer> dao;
    private List<AbstractTransport> abstractTransportList;
    private List<Station> stationList;

    public PathModel(List<AbstractTransport> abstractTransportList, List<Node> nodeList) {
        this.abstractTransportList = abstractTransportList;
        this.stationList = nodeToAddress(nodeList);
    }

    private List<Station> nodeToAddress(List<Node> nodeList) {
        List<Station> stationList = new ArrayList<>();
        this.dao = new StationDAO();
        for(Node node: nodeList) {
            stationList.add(dao.getByStationId(node.getId()));
        }
        return stationList;
    }

    public IStationDao<Station, Integer> getDao() {
        return dao;
    }

    public void setDao(IStationDao<Station, Integer> dao) {
        this.dao = dao;
    }

    public List<AbstractTransport> getAbstractTransportList() {
        return abstractTransportList;
    }

    public void setAbstractTransportList(List<AbstractTransport> abstractTransportList) {
        this.abstractTransportList = abstractTransportList;
    }

    public List<Station> getStationList() {
        return stationList;
    }

    public void setStationList(List<Station> stationList) {
        this.stationList = stationList;
    }
}
