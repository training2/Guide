package com.training2.guide.algorithm.dijkstra.models;

import java.util.List;

public class Node {

    private int id;
    private List<Integer> objectList;
    private List<Integer> weightLinkList;
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

    public List<Integer> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<Integer> objectList) {
        this.objectList = objectList;
    }

    public List<Integer> getWeightLinkList() {
        return weightLinkList;
    }

    public void setWeightLinkList(List<Integer> weightLinkList) {
        this.weightLinkList = weightLinkList;
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
