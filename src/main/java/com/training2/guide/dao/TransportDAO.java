package com.training2.guide.dao;

import com.training2.guide.models.Station;
import com.training2.guide.models.Transport;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.training2.guide.util.dao.constants.TransportDaoConstants.*;

/**
 * Created by Kirill on 20.07.2016.
 */
public class TransportDAO extends AbstractDao<Transport, Integer> {

    @Override
    public List<Transport> getListById(Integer addressId) {
        List<Transport> transportList = new ArrayList<>();
        List<Station> stationList = new ArrayList<>();
        Transport transport = new Transport();
        Station station = new Station();
        PreparedStatement preparedStatement = getPreparedStatement(GET_TRANSPORT_BY_ADDRESS_ID);
        try {
            preparedStatement.setInt(1, addressId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int transportId = resultSet.getInt("id");
                transport.setId(transportId);
                transport.setTransportType(resultSet.getString("transportType"));
                preparedStatement = getPreparedStatement(GET_ADDRESS_BY_TRANSPORT);
                preparedStatement.setInt(1, transportId);
                ResultSet addressResultSet = preparedStatement.executeQuery();
                while(addressResultSet.next()) {
                    station.setId(addressResultSet.getInt("id"));
                    station.setCity(addressResultSet.getString("city"));
                    station.setStreet(addressResultSet.getString("street"));
                    stationList.add(station);
                    station = new Station();
                }
                transport.setStationList(stationList);
                transportList.add(transport);
                transport = new Transport();
                stationList = new ArrayList<>();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transportList;
    }

    @Override
    public Transport getById(Integer id) {
        return null;
    }
}



