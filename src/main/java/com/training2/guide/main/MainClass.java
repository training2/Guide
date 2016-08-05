package com.training2.guide.main;

import com.training2.guide.algorithm.guide.OrderExecuter;
import com.training2.guide.dao.DaoFactory;
import org.apache.log4j.PropertyConfigurator;

import java.io.InputStream;

public class MainClass {

    public static final String LOG_FILE_NAME = "src/main/resources/log4j.xml";

    public static void main(String[] args) {

        InputStream inputStream = MainClass.class.getClassLoader().getResourceAsStream(LOG_FILE_NAME);
        PropertyConfigurator.configure(LOG_FILE_NAME);

        //InitDB.init();

        DaoFactory.initTypeOfDaoFactory(DaoFactory.MYBATIS);
        OrderExecuter executer = new OrderExecuter();
        executer.executeAll();
    }
}
