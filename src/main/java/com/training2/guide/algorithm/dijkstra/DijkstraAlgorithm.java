package com.training2.guide.algorithm.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class DijkstraAlgorithm {

    private List<Node> nodeList;

    public DijkstraAlgorithm() {
        init();
    }

    class Node {
        private int id;
        private List<Integer> adresses;
        private List<Integer> distances;
        private int w;
        private int from;

        public Node(int w, int from) {
            this.w = w;
            this.from = from;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<Integer> getAdresses() {
            return adresses;
        }

        public void setAdresses(List<Integer> adresses) {
            this.adresses = adresses;
        }

        public List<Integer> getDistances() {
            return distances;
        }

        public void setDistances(List<Integer> distances) {
            this.distances = distances;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }
    }

    private void init() {

    }

    private void initNodes() {
        nodeList = new ArrayList<Node>();
        List<Integer> address;
        for(int i = 1; i <= 6; i++) {
            Node node = new Node(Integer.MAX_VALUE, 0);
            node.setId(i);
            node.setAdresses();
            nodeList.add(node);
        }
    }
}
