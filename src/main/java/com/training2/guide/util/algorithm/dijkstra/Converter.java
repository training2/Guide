package com.training2.guide.util.algorithm.dijkstra;

import com.training2.guide.algorithm.dijkstra.models.NeighborPoint;
import com.training2.guide.algorithm.dijkstra.models.Node;
import com.training2.guide.models.NeighborStation;
import com.training2.guide.models.Route;

import java.util.ArrayList;
import java.util.List;

/**
 * This class use to convert some models to algorithm-models
 * @author rutkovba
 */
public class Converter {

    public static Node convertRouteToNode(Route route) {
        Node node = new Node();
        NeighborPoint neighborPoint = new NeighborPoint();
        List<NeighborPoint> neighborPointList = new ArrayList<>();
        node.setId(route.getStation().getId());
        for(NeighborStation neighborStation: route.getNeighborStationList()) {
            neighborPoint.setPoint(neighborStation.getStation().getId());
            neighborPoint.setObject(neighborStation.getNeighborStation().getId());
            neighborPoint.setWeightLink(neighborStation.getDistance());
            neighborPointList.add(neighborPoint);
            neighborPoint = new NeighborPoint();
        }
        node.setNeighborPointList(neighborPointList);
        node.setFromObject(0);
        node.setWeightObject(Integer.MAX_VALUE);
        return node;
    }
}
