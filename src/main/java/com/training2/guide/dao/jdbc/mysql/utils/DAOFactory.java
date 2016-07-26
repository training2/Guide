/**
 * This class open connection with helps driver to DB
 * @author Dmitry Minchuk,Kirill Bugrim on 20.07.2016.
 * @version 1.1
 */

package com.training2.guide.dao.jdbc.mysql.utils;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

import static com.training2.guide.util.GuideProperties.getParameter;

public class DAOFactory {

    private static final Logger LOG = Logger.getLogger(DAOFactory.class);

    private final static String DRIVER="driver", URL="url",USERNAME="username",PASSWORD="password";
    private static Connection connection = null;
    private static BasicDataSource dataSource = null;

    private DAOFactory() {
    }

    public static Connection getDataSource(){

        if (dataSource == null){
            dataSource = new BasicDataSource();
            dataSource.setUsername(getParameter(USERNAME));
            dataSource.setPassword(getParameter(PASSWORD));
            dataSource.setDriverClassName(getParameter(DRIVER));
            dataSource.setUrl(getParameter(URL));
            dataSource.setInitialSize(1);//number of connections on start
            dataSource.setMaxTotal(10);//max number of connections
            dataSource.setMaxConnLifetimeMillis(6000);//max time for each connection

            try {
                connection = dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}

