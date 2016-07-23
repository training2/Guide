package com.training2.guide.algorithm.guide;

import com.training2.guide.algorithm.dijkstra.models.Node;
import com.training2.guide.dao.AbstractDao;
import com.training2.guide.dao.TransportDAO;
import com.training2.guide.exceptions.TransportNotFoundException;
import com.training2.guide.models.AbstractTransport;
import com.training2.guide.models.Station;

import java.util.ArrayList;
import java.util.List;

public class GuideLogic {

    private List<Node> nodeList;
    private List<AbstractTransport> abstractTransportPath;
    private AbstractDao<AbstractTransport, Integer> dao;

    public GuideLogic(List<Node> nodeList) {
        this.nodeList = nodeList;
        this.abstractTransportPath = new ArrayList<>();
        this.dao = new TransportDAO();
    }

    public List<AbstractTransport> getLogic() throws TransportNotFoundException {

        boolean hasTransport = false;
        AbstractTransport currentAbstractTransport = null;
        int i = 0;
        for(Node node: nodeList) {
            i++;
            int nextId = 0;
            int currentId = node.getId();
            if(hasNextnode(i)) {
                nextId = nodeList.get(i).getId();
            }
            if(currentAbstractTransport != null && goesToNextStation(currentAbstractTransport, nextId)) {
                abstractTransportPath.add(currentAbstractTransport);
                continue;
            }
            List<AbstractTransport> abstractTransportList = dao.getListById(currentId);
            for(AbstractTransport abstractTransport : abstractTransportList) {
                for(Station station : abstractTransport.getStationList()) {
                    if(goesToNextStation(abstractTransport, nextId) && station.getId() == getNodeById(currentId).getId()) {
                        currentAbstractTransport = abstractTransport;
                        abstractTransportPath.add(currentAbstractTransport);
                        hasTransport = true;
                        break;
                    }
                }
                if(hasTransport)
                    break;
            }
            if(hasNextnode(i) && !hasTransport)
                throw new TransportNotFoundException("Transports don`t go from station.id = " + currentId
                        + " to station.id = " + nextId);
            hasTransport = false;
        }
        return abstractTransportPath;
    }

    private boolean hasNextnode(int i) {
        if(i < nodeList.size()) {
            return true;
        }
        return false;
    }

    private boolean goesToNextStation(AbstractTransport abstractTransport, int currentId) {
        boolean goesToNext = false;
        for(Station station : abstractTransport.getStationList()) {
            if(station.getId() == currentId) {
                goesToNext = true;
                break;
            }
        }
        return goesToNext;
    }

    private Node getNodeById(int id) {
        Node node = null;
        for(Node nod: nodeList) {
            if(nod.getId() == id) {
                node = nod;
            }
        }
        return node;
    }
}
