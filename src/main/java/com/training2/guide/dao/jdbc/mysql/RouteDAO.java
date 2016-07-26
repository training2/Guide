/**
 * @author Kirill Bugrim on 20.07.2016.
 * @version 1.1
 */

package com.training2.guide.dao.jdbc.mysql;
import com.training2.guide.dao.IRouteDao;
import com.training2.guide.dao.jdbc.mysql.utils.DAOFactory;
import com.training2.guide.models.NeighborStation;
import com.training2.guide.models.Station;
import com.training2.guide.models.Route;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDAO extends AbstractMySQLDao implements IRouteDao<Route, Integer> {

    private static final Logger LOG = Logger.getLogger(DAOFactory.class);

    private static final String GET_ALL_BY_ADDRESS_ID = "select * from route where station_from= ?";
    private final static String STATION_FROM="station_from",DISTANCE="distance",STATION_TO="station_to";
    private final static String TRANSPORT_STATION="insert into transportRoute_station values(?,?)";
    private final static int[] STATION={5,7,1,1,2,2,2,3,3,3,4,4,5,5,6,6,7,7,8,9,9,10,10,11,11,12,12,13,14,15,16,17,18,2,2,5,9,12};
    private final static int[] ROUTE={11,11,1,6,7,12,2,2,13,14,1,13,6,12,1,6,3,8,3,10,16,8,3,15,16,15,16,4,4,4,5,5,5,14,6,7,8,10};

    @Override
    public void create() {
        PreparedStatement preparedStatement = getPreparedStatement(TRANSPORT_STATION);
        try {

            for (int i = 0; i <STATION.length; i++) {
                preparedStatement.setInt(1,STATION[i]);
                preparedStatement.setInt(2,ROUTE[i]);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            LOG.error("SQLException", e);
        }finally {

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    LOG.error("SQLException", e);
                }
            }
            connectionClose();
        }
    }

    @Override
    public Route getByStationId(Integer addressId) {
        Route route = new Route();
        NeighborStation neighborStation = new NeighborStation();
        PreparedStatement preparedStatement = getPreparedStatement(GET_ALL_BY_ADDRESS_ID);
        Station station = new StationDAO().getByStationId(addressId);
        route.setStation(station);

        List<NeighborStation> neighborStationList = new ArrayList<>();
        try {
            preparedStatement.setInt(1, addressId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                station =new StationDAO().getByStationId(result.getInt(STATION_FROM));
                neighborStation.setStation(station);
                neighborStation.setDistance(result.getInt(DISTANCE));
                neighborStation.setNeighborStation(new StationDAO().getByStationId(result.getInt(STATION_TO)));
                neighborStationList.add(neighborStation);
                neighborStation = new NeighborStation();
            }

            route.setNeighborStationList(neighborStationList);
        } catch (SQLException e) {
            LOG.error("SQLException", e);
        } finally {
            connectionClose();
        }
        return route;
    }

    @Override
    public List<Route> getListByStationId(Integer stationId){
        throw new UnsupportedOperationException();
    }


    @Override
    public List<Route> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException();
    }


    @Override
    public Route getById(int id) {
        throw new UnsupportedOperationException();
    }
}
