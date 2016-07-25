package com.training2.guide.algorithm.dijkstra.models;

/**
 * This class connect object and neighbor object and have weight of link
 * @author rutkovba
 * @see Node
 */
public class NeighborPoint {

    private Integer point;
    private Integer object;
    private Integer weightLink;

    public NeighborPoint() {
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getObject() {
        return object;
    }

    public void setObject(Integer object) {
        this.object = object;
    }

    public Integer getWeightLink() {
        return weightLink;
    }

    public void setWeightLink(Integer weightLink) {
        this.weightLink = weightLink;
    }
}
