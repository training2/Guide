package com.training2.guide.algorithm.guide;

import com.training2.guide.algorithm.dijkstra.DijkstraAlgorithm;
import com.training2.guide.algorithm.dijkstra.models.Node;
import com.training2.guide.dao.jdbc.IPassangerPathDao;
import com.training2.guide.dao.jdbc.mysql.PassangerPathDao;
import com.training2.guide.exceptions.TransportNotFoundException;
import com.training2.guide.io.IOutput;
import com.training2.guide.io.guide.PrintToConsole;
import com.training2.guide.io.guide.PrintToDB;
import com.training2.guide.models.PassangerPath;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * TYhis class execute the search for some "orders"
 * @author rutkovba
 */
public class OrderExecuter {

    private Logger LOG = Logger.getLogger(OrderExecuter.class);

    private PassangerPath path;
    private List<PassangerPath> pathList;
    private DijkstraAlgorithm dijkstra;
    private Integer count;
    private IPassangerPathDao<PassangerPath, Integer> dao;
    private IOutput output;

    public OrderExecuter() {
        this.path = new PassangerPath();
        this.pathList = new ArrayList<>();
        this.count = 0;
        this.dao = new PassangerPathDao();
    }

    public void execute(int id) {
        path = dao.getById(id);
        initPrint(path);
    }

    public void executeAll() {
        pathList = dao.getAll();
        for(PassangerPath path: pathList) {
            initPrint(path);
        }
    }

    public void execute(int stratId, int endId) {
        count = dao.getCount();
        for(int currentId = 0; currentId < count; currentId++) {
            path = dao.getById(currentId);
            initPrint(path);
        }
    }

    private List<Node> initPrint(PassangerPath path) {
        dijkstra = new DijkstraAlgorithm(path.getStationFrom().getId(), path.getStationTo().getId());
        List<Node> nodeList = dijkstra.algorithm();
        try {
            output = new PrintToConsole(nodeList);
            output.print();
            output = new PrintToDB(path, nodeList);
            output.print();
        } catch (TransportNotFoundException e) {
            e.printStackTrace();
        }
        return nodeList;
    }
}
