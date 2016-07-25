package com.training2.guide.algorithm.dijkstra;

import com.training2.guide.algorithm.dijkstra.models.NeighborPoint;
import com.training2.guide.algorithm.dijkstra.models.Node;
import com.training2.guide.dao.jdbc.AbstractDao;
import com.training2.guide.dao.jdbc.RouteDAO;
import com.training2.guide.models.Route;
import com.training2.guide.util.MapUtils;
import com.training2.guide.util.algorithm.dijkstra.Converter;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * This class serves for use dijkstra algorithm
 * @author rutkovba
 */
public class DijkstraAlgorithm {

    private Logger LOG = Logger.getLogger(DijkstraAlgorithm.class);

    private List<Node> nodes;
    private int startIndex;
    private int endIndex;
    private Map<Integer, Integer> map;
    private Map.Entry entry;
    private List<Node> nodeList;
    private List<Integer> oldNodes;
    private AbstractDao<Route, Integer> dao;

    public DijkstraAlgorithm(int start, int end) {
        this.startIndex = start;
        this.endIndex = end;
        this.map = new TreeMap<>();
        this.nodeList = new ArrayList<>();
        this.oldNodes = new ArrayList<>();
        this.dao = new RouteDAO();
    }

    /**
     * This is algorithm
     * @return list of nodes
     */
    public List<Node> algorithm() {

        int currentId = startIndex;
        Node n = Converter.convertRouteToNode(dao.getByStationId(currentId));
        nodeList.add(n);
        getNodeByIdLocal(currentId).setWeightObject(0);

        map.put(getNodeByIdLocal(currentId).getId(), getNodeByIdLocal(currentId).getWeightObject());

        while(true) {

            if(map.isEmpty()) {
                LOG.debug("Not found connections for points");
                return new ArrayList<>();
            }
            entry = getMinKeyEntry();
            currentId = (int) entry.getKey();
            Node currentNode = getNodeByIdLocal(currentId);

            if (currentId == endIndex) {
                LOG.debug("Algorithm end");
                break;
            }

            for (NeighborPoint neighborPoint: currentNode.getNeighborPointList()) {
                int index = neighborPoint.getObject();
                if(!hasOldId(index)) {
                    if (!hasId(index)) nodeList.add(Converter.convertRouteToNode(dao.getByStationId(index)));
                    if ((currentNode.getWeightObject() + neighborPoint.getWeightLink()) <
                            getNodeByIdLocal(index).getWeightObject()) {
                        getNodeByIdLocal(index).setWeightObject(currentNode.getWeightObject() + neighborPoint.getWeightLink());
                        getNodeByIdLocal(index).setFromObject(currentNode.getId());
                        map.put(index, currentNode.getWeightObject() + neighborPoint.getWeightLink());
                    }
                }
            }
            oldNodes.add(currentId);
            map.remove(currentId);
        }
        nodeList = getPath();
        return nodeList;
    }

    /**
     * Get Node by id from local list, which was filled from DB
     * @param id
     * @return
     */
    private Node getNodeByIdLocal(int id) {
        Node nod = null;
        for(Node node: nodeList) {
            if(node.getId() == id) {
                nod = node;
                break;
            }
        }
        return nod;
    }

    /**
     * Check for old nodes
     * @param id
     * @return
     */
    private boolean hasOldId(int id) {
        for(Integer oldId: oldNodes) {
            if(oldId == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check for content local nodes by id
     * @param id
     * @return
     */
    private boolean hasId(int id) {
        for(Node node: nodeList) {
            if(node.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Use for dijkstra algorithm for found a reverse path
     * @return
     */
    private List<Node> getPath() {
        List<Node> pathList = new ArrayList<>();
        pathList.add(getNodeByIdLocal(endIndex));
        int fromIndex;
        while(endIndex != startIndex) {
            fromIndex = getNodeByIdLocal(endIndex).getFromObject();
            pathList.add(getNodeByIdLocal(fromIndex));
            endIndex = fromIndex;
        }
        Collections.reverse(pathList);
        return pathList;
    }

    private Map.Entry getMinKeyEntry() {
        return (Map.Entry) MapUtils.sortByValues(map).entrySet().toArray()[0];
    }

    /** Use for init map if all nodes are locals
     * @deprecated
     * @param nodeList
     */
    @Deprecated
    private void initMap(List<Node> nodeList) {
        for(Node node: nodeList) {
            map.put(node.getWeightObject(), node.getId());
        }
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
