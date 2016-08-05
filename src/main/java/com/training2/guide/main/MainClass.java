package com.training2.guide.main;

import com.training2.guide.algorithm.guide.OrderExecuter;
import com.training2.guide.dao.DaoFactory;
import org.apache.log4j.PropertyConfigurator;

import java.io.InputStream;

public class MainClass {

    public static void main(String[] args) {

        //InitDB.init();

        DaoFactory.initTypeOfDaoFactory(DaoFactory.MYBATIS);
        OrderExecuter executer = new OrderExecuter();
        executer.executeAll();
    }
}
