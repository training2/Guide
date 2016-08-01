package com.training2.guide.algorithm.guide;

import com.training2.guide.algorithm.dijkstra.models.Node;
import com.training2.guide.dao.DaoFactory;
import com.training2.guide.dao.ITransportDao;
import com.training2.guide.exceptions.TransportNotFoundException;
import com.training2.guide.models.AbstractTransport;
import com.training2.guide.models.Station;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * This class have an algorithm for create path by dijkstra algorithm
 * @author rutkovba
 */
public class GuideLogic {

    private Logger LOG = Logger.getLogger(GuideLogic.class);

    private List<Node> nodeList;
    private List<AbstractTransport> abstractTransportPath;
    private ITransportDao<AbstractTransport, Integer> dao;

    public GuideLogic(List<Node> nodeList) {
        this.nodeList = nodeList;
        this.abstractTransportPath = new ArrayList<>();
        this.dao = DaoFactory.getInstance().getTransportDao();
    }

    /**
     * This is an algorithm for create path
     * @return
     * @throws TransportNotFoundException
     */
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
                LOG.info("Current transport " + currentId + " goes to next station");
                abstractTransportPath.add(currentAbstractTransport);
                continue;
            }
            List<AbstractTransport> abstractTransportList = dao.getListByStationId(currentId);
            for(AbstractTransport abstractTransport : abstractTransportList) {
                for(Station station : abstractTransport.getStationList()) {
                    if(goesToNextStation(abstractTransport, nextId) && station.getId() == getNodeById(currentId).getId()) {
                        LOG.info("Add transport " + currentAbstractTransport + " to path");
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

    /**
     * Check for next node in nodes list
     * @param i
     * @return
     */
    private boolean hasNextnode(int i) {
        if(i < nodeList.size()) {
            return true;
        }
        return false;
    }

    /**
     * Check that transport goes to next station
     * @param abstractTransport
     * @param currentId
     * @return
     */
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

    /**
     * Use to get Node by id local
     * @param id
     * @return
     */
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
