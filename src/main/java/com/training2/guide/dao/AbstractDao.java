package com.training2.guide.dao;

import com.training2.guide.dao.jdbc.DAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao<E, K> {

    public abstract E getById(K id);
    public abstract List<E> getListById(K addressId);

    public PreparedStatement getPreparedStatement(String query) {
        Connection connection = DAOFactory.createConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
        } catch (SQLException e) {
            //LOG.error("SQLException", e);
        }
        return preparedStatement;
    }
}
