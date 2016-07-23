package com.training2.guide.dao;

import com.training2.guide.models.City;
import com.training2.guide.models.Station;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Kirill on 20.07.2016.
 */
public class StationDAO extends AbstractDao<Station, Integer> {

    private static final String GET_ALL_BY_ADDRESS_ID = "select s.id, s.street, c.id as cityId, c.cityName from stations s inner join cities c on (s.id_City = c.id) where (s.id = ?)";

    public StationDAO() {
    }

    @Override
     public Station getById(Integer addressId) {
        Station station = new Station();
        City city = new City();
        PreparedStatement preparedStatement = getPreparedStatement(GET_ALL_BY_ADDRESS_ID);
        try {
            preparedStatement.setInt(1, addressId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                station.setId(result.getInt("id"));
                city.setId(result.getInt("cityId"));
                city.setCityName(result.getString("cityName"));
                station.setStreet(result.getString("street"));
                station.setCity(city);
                city = new City();
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

