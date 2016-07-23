package com.training2.guide.dao;

import com.training2.guide.models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirill on 20.07.2016.
 */
public class TransportDAO extends AbstractDao<AbstractTransport, Integer> {

    String GET_TRANSPORT_BY_ADDRESS_ID = "select t.id as transportTypeId, tr.id, tr.numberOfRoute from transports t inner join transportsRoute" +
            " tr on (t.id = tr.id_transports) inner join transportRoute_station trs on (tr.id = trs.idTransport)" +
            " where (trs.id_station = ?)";
    String GET_ADDRESS_BY_TRANSPORT = "select s.id, s.street, c.id as cityId, c.cityName from stations s inner join cities c on " +
            "(s.id_City = c.id) inner join transportRoute_station trs on (trs.id_station = s.id) where (trs.idTransport = ?)";

    @Override
    public List<AbstractTransport> getListById(Integer stationId) {
        List<AbstractTransport> abstractTransportList = new ArrayList<>();
        List<Station> stationList = new ArrayList<>();
        AbstractTransport abstractTransport = null;
        Station station = new Station();
        City city = new City();
        PreparedStatement preparedStatement = getPreparedStatement(GET_TRANSPORT_BY_ADDRESS_ID);
        try {
            preparedStatement.setInt(1, stationId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int transportId = resultSet.getInt("id");
                int transportTypeId = resultSet.getInt("transportTypeId");
                abstractTransport = getType(transportTypeId);
                abstractTransport.setId(transportId);
                abstractTransport.setTransportNumber(resultSet.getInt("numberOfRoute"));
                preparedStatement = getPreparedStatement(GET_ADDRESS_BY_TRANSPORT);
                preparedStatement.setInt(1, transportId);
                ResultSet addressResultSet = preparedStatement.executeQuery();
                while(addressResultSet.next()) {
                    station.setId(addressResultSet.getInt("id"));
                    station.setStreet(addressResultSet.getString("street"));
                    city.setId(addressResultSet.getInt("cityId"));
                    city.setCityName(addressResultSet.getString("cityName"));
                    station.setCity(city);
                    city = new City();
                    stationList.add(station);
                    station = new Station();
                }
                abstractTransport.setStationList(stationList);
                abstractTransportList.add(abstractTransport);
                stationList = new ArrayList<>();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return abstractTransportList;
    }

    @Override
    public AbstractTransport getById(Integer id) {
        return null;
    }

    private AbstractTransport getType(int id) {
        AbstractTransport abstractTransport = null;
        switch(id) {
            case 1:
                abstractTransport = new Bus();
                break;
            case 2: abstractTransport = new Trolleybus();
                break;
            case 3: abstractTransport = new Train();
                break;
            case 4: abstractTransport = new Tram();
                break;
            default: break;
        }
        return abstractTransport;
    }
}



