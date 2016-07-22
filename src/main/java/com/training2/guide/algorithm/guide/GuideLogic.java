package com.training2.guide.algorithm.guide;

import com.training2.guide.algorithm.dijkstra.models.Node;
import com.training2.guide.models.Address;
import com.training2.guide.dao.AbstractDao;
import com.training2.guide.dao.TransportDAO;
import com.training2.guide.models.Transport;
import java.util.ArrayList;
import java.util.List;

public class GuideLogic {

    private List<Node> nodeList;
    private List<Transport> transportPath;
    private AbstractDao<Transport, Integer> dao;

    public GuideLogic(List<Node> nodeList) {
        this.nodeList = nodeList;
        this.transportPath = new ArrayList<>();
        this.dao = new TransportDAO();
    }

    public List<Transport> getLogic() {

        boolean hasTransport = false;
        Transport currentTransport = null;
        int i = 0;
        for(Node node: nodeList) {
            i++;
            int nextId = 0;
            int currentId = node.getId();
            if(hasNextnode(i)) {
                nextId = nodeList.get(i).getId();
            }
            if(currentTransport != null && goesToNextStation(currentTransport, nextId)) {
                transportPath.add(currentTransport);
                continue;
            }
            List<Transport> transportList = dao.getListById(currentId);
            for(Transport transport: transportList) {
                for(Address address: transport.getAddressList()) {
                    boolean b = goesToNextStation(transport, nextId);
                    if(b && address.getId() == getNodeById(currentId).getId()) {
                        currentTransport = transport;
                        transportPath.add(currentTransport);
                        hasTransport = true;
                        break;
                    }
                }
                if(hasTransport) break;
            }
            hasTransport = false;
        }
        return transportPath;
    }

    private boolean hasNextnode(int i) {
        if(i < nodeList.size()) {
            return true;
        }
        return false;
    }

    private boolean goesToNextStation(Transport transport, int currentId) {
        boolean goesToNext = false;
        for(Address address: transport.getAddressList()) {
            if(address.getId() == currentId) {
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
