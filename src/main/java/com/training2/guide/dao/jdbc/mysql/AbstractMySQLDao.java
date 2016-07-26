package com.training2.guide.dao.jdbc.mysql;

import com.training2.guide.dao.jdbc.mysql.utils.DAOFactory;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Have some acts on DB
 * @author rutkovba
 */
public abstract class AbstractMySQLDao<E, K> {

    private static final Logger LOG = Logger.getLogger(AbstractMySQLDao.class);

    private Connection connection = null;

    /*public abstract List<E> getAll();
    public abstract E getById(int id);
    public abstract int getCount();
    public abstract E getByStationId(K id);
    public abstract List<E> getListByStationId(K stationId);
    public  abstract void create();*/

    protected PreparedStatement getPreparedStatement(String query) {
        Connection connection = DAOFactory.getDataSource();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
        } catch (SQLException e) {
            LOG.error("SQLException", e);
        }
        return preparedStatement;
    }

    public void connectionClose() {
        /*if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
    }
}
