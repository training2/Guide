package com.training2.guide.dao;

import com.training2.guide.models.NeighborStation;
import com.training2.guide.models.Station;
import com.training2.guide.models.Route;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Kirill on 20.07.2016.
 */
public class RouteDAO extends AbstractDao<Route, Integer> {

    private static final String GET_ALL_BY_ADDRESS_ID = "select * from route where station_from= ?";

    @Override
    public Route getById(Integer addressId) {
        Route route = new Route();
        NeighborStation neighborStation = new NeighborStation();
        PreparedStatement preparedStatement = getPreparedStatement(GET_ALL_BY_ADDRESS_ID);
        Station station = new StationDAO().getById(addressId);
        route.setStation(station);

         List<NeighborStation> neighborStationList = new ArrayList<>();
        try {
            preparedStatement.setInt(1, addressId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                station =new StationDAO().getById(result.getInt("station_from"));
                neighborStation.setStation(station);
                neighborStation.setDistance(result.getInt("distance"));
                neighborStation.setNeighborStation(new StationDAO().getById(result.getInt("station_to")));
                neighborStationList.add(neighborStation);
                neighborStation = new NeighborStation();
            }

            route.setNeighborStationList(neighborStationList);

            if (preparedStatement !=null) preparedStatement.close();
            if (result!=null) result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return route;
    }

    @Override
    public List<Route> getListById(Integer id) {
        return null;
    }
}
