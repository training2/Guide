package com.training2.guide.util.algorithm.dijkstra;

import com.training2.guide.algorithm.dijkstra.models.Node;
import com.training2.guide.models.Address;
import com.training2.guide.models.Route;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static Node convertRouteToNode(Route route) {
        Node node = new Node();
        node.setId(route.getAddress().getId());
        List<Integer> objectList = new ArrayList<>();
        List<Integer> weightLinkList = new ArrayList<>();
        for(Address address: route.getNeighborAddresses()) {
            objectList.add(address.getId());
        }
        node.setObjectList(objectList);
        node.setWeightLinkList(route.getDistanceList());
        node.setFromObject(0);
        node.setWeightObject(Integer.MAX_VALUE);
        return node;
    }
}
