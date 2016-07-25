package com.training2.guide.algorithm.dijkstra.models;

import java.util.List;

/**
 * This class connect object and all his neighbor objects and have weights of links
 * Have list of substructure NeighborPoint
 * @author rutkovba
 * @see NeighborPoint
 */
public class Node {

    private int id;
    private List<NeighborPoint> neighborPointList;
    private int weightObject;
    private int fromObject;

    public Node() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<NeighborPoint> getNeighborPointList() {
        return neighborPointList;
    }

    public void setNeighborPointList(List<NeighborPoint> neighborPointList) {
        this.neighborPointList = neighborPointList;
    }

    public int getWeightObject() {
        return weightObject;
    }

    public void setWeightObject(int weightObject) {
        this.weightObject = weightObject;
    }

    public int getFromObject() {
        return fromObject;
    }

    public void setFromObject(int fromObject) {
        this.fromObject = fromObject;
    }
}
