package com.training2.guide.main;

import com.training2.guide.algorithm.guide.OrderExecuter;
import org.apache.log4j.PropertyConfigurator;

public class MainClass {

    public static final String LOG_FILE_NAME = "src/main/resources/log4j.xml";

    public static void main(String[] args) {

        PropertyConfigurator.configure(LOG_FILE_NAME);

        //InitDB.init();

        OrderExecuter executer = new OrderExecuter();
        executer.executeAll();
    }
}
