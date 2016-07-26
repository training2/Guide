/**
 * @author Kirill Bugrim on 20.07.2016.
 * @version 1.1
 */
package com.training2.guide.dao.jdbc.mysql;
import com.training2.guide.dao.ITransportDao;
import com.training2.guide.dao.jdbc.mysql.utils.DAOFactory;
import com.training2.guide.models.*;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirill on 20.07.2016.
 */
public class TransportDAO extends AbstractMySQLDao implements ITransportDao<AbstractTransport, Integer> {

    private static final Logger LOG = Logger.getLogger(DAOFactory.class);

    private final String GET_TRANSPORT_BY_ADDRESS_ID = "select t.id as transportTypeId, tr.id, tr.numberOfRoute from transports t inner join transportsRoute" +
            " tr on (t.id = tr.transport_id) inner join transportRoute_station trs on (tr.id = trs.transport_id)" +
            " where (trs.station_id = ?)";
    private final String GET_ADDRESS_BY_TRANSPORT = "select s.id, s.street, c.id as cityId, c.cityName from stations s inner join cities c on " +
            "(s.city_id = c.id) inner join transportRoute_station trs on (trs.station_id = s.id) where (trs.transport_id = ?)";
    private final String GET_TYPE_TRANSPORT = "select typeTransport from transportsroute tr inner join transports ts on tr.transport_id=ts.id " +
            "where tr.id=?";
    private final static String INSERT_TRANSPORT ="insert into transports(typeTransport) values(?)";

    private final static String ID="id",TRANSPORT_TYPE_ID="transportTypeId",TRANSPORT_ROUTE="numberOfRoute",STREET="street",
            CITY_ID="cityId",CITY_NAME="cityName",TYPE_TRANSPORT="typeTransport";

    private final static String[] TRANSPORT_TYPE={"Bus","TrolleyBus","Train","Tram","Taxi"};

    @Override
    public void create() {
        PreparedStatement preparedStatement = getPreparedStatement(INSERT_TRANSPORT);
        try {

            for (int i = 0; i <TRANSPORT_TYPE.length; i++) {
                preparedStatement.setString(1,TRANSPORT_TYPE[i]);
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
    public List<AbstractTransport> getListByStationId(Integer stationId) {
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
                int transportId = resultSet.getInt(ID);
                int transportTypeId = resultSet.getInt(TRANSPORT_TYPE_ID);
                abstractTransport = getType(transportTypeId);
                abstractTransport.setId(transportId);
                abstractTransport.setTransportNumber(resultSet.getInt(TRANSPORT_ROUTE));
                preparedStatement = getPreparedStatement(GET_ADDRESS_BY_TRANSPORT);
                preparedStatement.setInt(1, transportId);
                ResultSet addressResultSet = preparedStatement.executeQuery();
                while(addressResultSet.next()) {
                    station.setId(addressResultSet.getInt(ID));
                    station.setStreet(addressResultSet.getString(STREET));
                    city.setId(addressResultSet.getInt(CITY_ID));
                    city.setCityName(addressResultSet.getString(CITY_NAME));
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
            LOG.error("SQLException", e);
        } finally {
            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connectionClose();
        }
        return abstractTransportList;
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

    @Override
    public String getTransportTypeById(Integer id) {
        String str="";

        PreparedStatement preparedStatement = getPreparedStatement(GET_TYPE_TRANSPORT);

        try {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                str = resultSet.getString(TYPE_TRANSPORT);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOG.error("SQLException", e);
            }
            connectionClose();

        }

        return str;
    }

    @Override
    public List<AbstractTransport> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException();
    }

    @Override
    public AbstractTransport getById(int id) {
        throw new UnsupportedOperationException();
    }
}



