package com.training2.guide.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.training2.guide.util.GuideProperties.*;

/**
 * Created by Kirill on 20.07.2016.
 */
public class DAOFactory {

    private static final String DRIVER_PATH = "com.mysql.jdbc.Driver";

    public DAOFactory() {
        createConnection();
    }

    public static Connection createConnection(){

        Connection connection = null;

        try {
            //Загружаем драйвер

            Class.forName(DRIVER_PATH);


            //Создаём соединение
            connection = DriverManager.getConnection(getURL(), getUsername(), getPassword());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }

        return connection;
    }

}

