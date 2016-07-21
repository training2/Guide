package com.training2.guide.algorithm.dijkstra;

import com.training2.guide.algorithm.dijkstra.models.Node;
import com.training2.guide.jdbc.dao.AbstractDao;
import com.training2.guide.jdbc.dao.RouteDAO;
import com.training2.guide.models.Route;
import com.training2.guide.util.MapUtils;
import com.training2.guide.util.algorithm.dijkstra.Converter;

import java.util.*;

public class DijkstraAlgorithm {

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

    public List<Node> algorithm() {

        int currentId = startIndex;
        Node n = Converter.convertRouteToNode(dao.getById(currentId));
        nodeList.add(n);
        getNodeByIdLocal(currentId).setWeightObject(0);

        map.put(getNodeByIdLocal(currentId).getId(), getNodeByIdLocal(currentId).getWeightObject());

        while(true) {

            if(map.isEmpty()) {
                System.out.println("Get taxi");
                return new ArrayList<>();
            }
            entry = getMinKeyEntry();
            currentId = (int) entry.getKey();
            Node currentNode = getNodeByIdLocal(currentId);

            if (currentId == endIndex) {
                break;
            }

            int pairsNumber = 0;
            for (Integer index : currentNode.getObjectList()) {
                if(!hasOldId(index)) {
                    if (!hasId(index)) nodeList.add(Converter.convertRouteToNode(dao.getById(index)));
                    if ((currentNode.getWeightObject() + currentNode.getWeightLinkList().get(pairsNumber)) <
                            getNodeByIdLocal(index).getWeightObject()) {
                        getNodeByIdLocal(index).setWeightObject(currentNode.getWeightObject() + currentNode.getWeightLinkList()
                                .get(pairsNumber));
                        getNodeByIdLocal(index).setFromObject(currentNode.getId());
                        map.put(index, currentNode.getWeightObject() + currentNode.getWeightLinkList()
                                .get(pairsNumber));
                    }
                }
                    pairsNumber++;
            }
            oldNodes.add(currentId);
            map.remove(currentId);
        }
        nodeList = getPath(nodeList);
        return nodeList;
    }

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

    private boolean hasOldId(int id) {
        for(Integer oldId: oldNodes) {
            if(oldId == id) {
                return true;
            }
        }
        return false;
    }

    private boolean hasId(int id) {
        for(Node node: nodeList) {
            if(node.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private List<Node> getPath(List<Node> nodeList) {
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

    /*public void initNodes() {
        nodes = new ArrayList<Node>();
        List<Integer> addressesList = new ArrayList<Integer>();
        addressesList.add(2);
        addressesList.add(3);
        List<Integer> distancesList = new ArrayList<Integer>();
        distancesList.add(8);
        distancesList.add(2);
        Node node = new Node();
        node.setWeightObject(Integer.MAX_VALUE);
        node.setFromObject(0);
        node.setId(1);
        node.setObjectList(addressesList);
        node.setWeightLinkList(distancesList);
        nodes.add(node);

        node = new Node();
        node.setId(2);
        node.setWeightObject(Integer.MAX_VALUE);
        node.setFromObject(0);
        addressesList = new ArrayList<Integer>();
        addressesList.add(1);
        addressesList.add(3);
        addressesList.add(4);
        addressesList.add(5);
        distancesList = new ArrayList<Integer>();
        distancesList.add(8);
        distancesList.add(15);
        distancesList.add(5);
        distancesList.add(1);
        node.setObjectList(addressesList);
        node.setWeightLinkList(distancesList);
        nodes.add(node);

        node = new Node();
        node.setId(3);
        node.setWeightObject(Integer.MAX_VALUE);
        node.setFromObject(0);
        addressesList = new ArrayList<Integer>();
        addressesList.add(1);
        addressesList.add(2);
        addressesList.add(4);
        addressesList.add(6);
        distancesList = new ArrayList<Integer>();
        distancesList.add(2);
        distancesList.add(15);
        distancesList.add(5);
        distancesList.add(10);
        node.setObjectList(addressesList);
        node.setWeightLinkList(distancesList);
        nodes.add(node);

        node = new Node();
        node.setId(4);
        node.setWeightObject(Integer.MAX_VALUE);
        node.setFromObject(0);
        addressesList = new ArrayList<Integer>();
        addressesList.add(2);
        addressesList.add(3);
        addressesList.add(5);
        distancesList = new ArrayList<Integer>();
        distancesList.add(5);
        distancesList.add(5);
        distancesList.add(2);
        node.setObjectList(addressesList);
        node.setWeightLinkList(distancesList);
        nodes.add(node);

        node = new Node();
        node.setId(5);
        node.setWeightObject(Integer.MAX_VALUE);
        node.setFromObject(0);
        addressesList = new ArrayList<Integer>();
        addressesList.add(2);
        addressesList.add(4);
        distancesList = new ArrayList<Integer>();
        distancesList.add(1);
        distancesList.add(2);
        node.setObjectList(addressesList);
        node.setWeightLinkList(distancesList);
        nodes.add(node);

        node = new Node();
        node.setId(6);
        node.setWeightObject(Integer.MAX_VALUE);
        node.setFromObject(0);
        addressesList = new ArrayList<Integer>();
        addressesList.add(3);
        distancesList = new ArrayList<Integer>();
        distancesList.add(10);
        node.setObjectList(addressesList);
        node.setWeightLinkList(distancesList);
        nodes.add(node);

        node = new Node();
        node.setId(7);
        node.setWeightObject(Integer.MAX_VALUE);
        node.setFromObject(0);
        addressesList = new ArrayList<Integer>();
        distancesList = new ArrayList<Integer>();
        node.setObjectList(addressesList);
        node.setWeightLinkList(distancesList);
        nodes.add(node);
    }*/
}
