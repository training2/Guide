package com.training2.guide.io.guide;

import com.training2.guide.algorithm.dijkstra.models.Node;
import com.training2.guide.dao.IPassangerPathDao;
import com.training2.guide.dao.jdbc.mysql.PassangerPathDao;
import com.training2.guide.exceptions.TransportNotFoundException;
import com.training2.guide.io.IOutput;
import com.training2.guide.models.PassangerPath;

import java.util.List;

public class PrintToDB extends AbstractOutput implements IOutput {

    private IPassangerPathDao<PassangerPath, Integer> dao;
    private PassangerPath path;

    public PrintToDB(PassangerPath path, List<Node> nodeList) throws TransportNotFoundException {
        super(nodeList);
        this.dao = new PassangerPathDao();
        this.path = path;
    }

    @Override
    public void print() {
        StringBuilder out = prepareOut();
        dao.createPath(path, out);
    }
}
