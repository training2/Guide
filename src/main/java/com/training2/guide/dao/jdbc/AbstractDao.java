package com.training2.guide.dao.jdbc;

import com.training2.guide.dao.jdbc.utils.DAOFactory;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Have some acts on DB
 * @param <E>
 * @param <K>
 * @author rutkovba
 */
public abstract class AbstractDao<E, K> {

    private static final Logger LOG = Logger.getLogger(AbstractDao.class);

    public abstract List<E> getAll();
    public abstract E getById(int id);
    public abstract int getCount();
    public abstract E getByStationId(K id);
    public abstract List<E> getListByStationId(K stationId);
    public  abstract void create();

    protected PreparedStatement getPreparedStatement(String query) {
        Connection connection = DAOFactory.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
        } catch (SQLException e) {
            LOG.error("SQLException", e);
        }
        return preparedStatement;
    }
}
