package com.training2.guide.dao;

import com.training2.guide.models.Station;
import com.training2.guide.models.Route;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.training2.guide.util.dao.constants.RouteDaoConstants.*;

/**
 * Created by Kirill on 20.07.2016.
 */
public class RouteDAO extends AbstractDao<Route, Integer> {

    @Override
    public Route getById(Integer addressId) {
        Route route = new Route();
        PreparedStatement preparedStatement = getPreparedStatement(GET_ALL_BY_ADDRESS_ID);
        Station station = new AddressDAO().getById(addressId);
        route.setStation(station);

         List<Station> listNeighborStations = new ArrayList<>();
         List<Integer> distanceList = new ArrayList<>();
        try {
            preparedStatement.setInt(1, addressId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                station =new AddressDAO().getById(result.getInt("to_address_id"));
                listNeighborStations.add(station);
                distanceList.add(result.getInt("distance"));
            }
            route.setDistanceList(distanceList);
            route.setNeighborStations(listNeighborStations);

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
