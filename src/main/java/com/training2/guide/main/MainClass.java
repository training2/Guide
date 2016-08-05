package com.training2.guide.main;

import com.training2.guide.algorithm.guide.OrderExecuter;
import com.training2.guide.dao.DaoFactory;
import com.training2.guide.util.InitDB;
import org.apache.log4j.PropertyConfigurator;

public class MainClass {

    public static final String LOG_FILE_NAME = "src/main/resources/log4j.xml";

    public static void main(String[] args) {

        PropertyConfigurator.configure(LOG_FILE_NAME);

        //InitDB.init();

        DaoFactory.initTypeOfDaoFactory(DaoFactory.MYBATIS);
        OrderExecuter executer = new OrderExecuter();
        executer.executeAll();
    }
}
