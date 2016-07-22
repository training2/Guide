package com.training2.guide.dao;

import com.training2.guide.models.Station;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Kirill on 20.07.2016.
 */
public class AddressDAO extends AbstractDao<Station, Integer> {

    private static final String GET_ALL_BY_ADDRESS_ID = "SELECT * FROM address where id = ?";

    public AddressDAO() {
    }

    @Override
     public Station getById(Integer addressId) {
        Station station = new Station();
        PreparedStatement preparedStatement = getPreparedStatement(GET_ALL_BY_ADDRESS_ID);
        try {
            preparedStatement.setInt(1, addressId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                station.setId(result.getInt("id"));
                station.setCity(result.getString("city"));
                station.setStreet(result.getString("street"));
            }
            if (preparedStatement !=null) preparedStatement.close();
            if (result!=null) result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return station;
    }

    @Override
    public List<Station> getListById(Integer id) {
        return null;
    }
}

