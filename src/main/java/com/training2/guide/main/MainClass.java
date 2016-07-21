package com.training2.guide.main;

import com.training2.guide.algorithm.dijkstra.DijkstraAlgorithm;
import com.training2.guide.algorithm.dijkstra.models.Node;
import com.training2.guide.algorithm.guide.GuideLogic;
import com.training2.guide.io.IOutput;
import com.training2.guide.io.guide.GuideOutput;
import com.training2.guide.models.Transport;

import java.util.List;

public class MainClass {

    public static final int start = 3;
    public static final int finish = 10;

    public static void main(String[] args) {

        DijkstraAlgorithm algorithm = new DijkstraAlgorithm(start, finish);

        List<Node> nodeList = algorithm.algorithm();

        GuideLogic guideLogic = new GuideLogic(nodeList);
        List<Transport> transportList = guideLogic.getLogic();

        IOutput output = new GuideOutput(transportList, nodeList);
        output.print();
    }
}
