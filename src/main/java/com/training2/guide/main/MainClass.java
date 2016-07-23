package com.training2.guide.main;

import com.training2.guide.algorithm.dijkstra.DijkstraAlgorithm;
import com.training2.guide.algorithm.dijkstra.models.Node;
import com.training2.guide.exceptions.TransportNotFoundException;
import com.training2.guide.io.IOutput;
import com.training2.guide.io.guide.GuideOutput;
import java.util.List;

public class MainClass {

    public static final int start = 3;
    public static final int finish = 10;

    public static void main(String[] args) {

        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(start, finish);

        List<Node> nodeList = dijkstra.algorithm();

        IOutput output = null;
        try {
            output = new GuideOutput(nodeList);
        } catch (TransportNotFoundException e) {
            e.printStackTrace();
        }
        output.print();
    }
}
