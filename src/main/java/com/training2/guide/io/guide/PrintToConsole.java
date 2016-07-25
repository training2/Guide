package com.training2.guide.io.guide;

import com.training2.guide.algorithm.dijkstra.models.Node;
import com.training2.guide.exceptions.TransportNotFoundException;
import com.training2.guide.io.IOutput;

import java.util.List;

/**
 * This class is a printer result ro console
 */
public class PrintToConsole extends AbstractOutput implements IOutput {

    public PrintToConsole(List<Node> nodeList) throws TransportNotFoundException {
        super(nodeList);
    }

    @Override
    public void print() {
        StringBuilder out = prepareOut();
        System.out.println(out);
    }
}
