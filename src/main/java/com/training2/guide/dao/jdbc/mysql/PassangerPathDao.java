/**
 * @author Kirill Bugrim on 20.07.2016.
 * @version 1.1
 */

package com.training2.guide.dao.jdbc.mysql;
import com.training2.guide.dao.IPassangerPathDao;
import com.training2.guide.dao.jdbc.mysql.utils.DAOFactory;
import com.training2.guide.models.Passanger;
import com.training2.guide.models.PassangerPath;
import com.training2.guide.models.Station;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassangerPathDao extends AbstractMySQLDao implements IPassangerPathDao<PassangerPath, Integer> {

    private static final Logger LOG = Logger.getLogger(DAOFactory.class);

    private static final String INSERT_ROUTES="insert into passengers_station(address_from, address_to, passenger_id) " +
            "values(?,?,?)";
    private static final String INSERT_ROUTE_TRANSPORT ="insert into transportsRoute(numberOfRoute,transport_id) values(?,?)";
    private static final String INSERT_PATH = "insert  into orders(orderId,route) values(?,?)";
    private static final String SELECT_ALL = "SELECT * FROM passengers_station";
    private static final String COUNT = "SELECT  count(*) FROM passengers_station";
    private static final String PASSANGER_PATH = "SELECT * FROM passengers_station where id=?";
    private static final String ID="id",ADDRESS_FROM="address_from",COUNTROW="count(*)",ADDRESS_TO="address_to",
            ID_PASSENGER="passenger_id";
    private static final int[] FROM={1,12,13,3,10,2,11,14,2,12};
    private static final int[] TO={5,15,5,6,5,6,8,2,4,5};
    private static final int[] ID_PASS={1,2,3,4,5,6,7,8,9,10};
    private static final int[] NUMBER_OF_ROUTE ={10,15,23,50,45,1,2,3,4,5,1,10,20,30,40,50};
    private static final int[] ID_TRANSPORT ={1,1,1,1,1,2,2,2,2,2,3,4,4,4,4,4};

    @Override
    public void createPath() {
        PreparedStatement preparedStatement = getPreparedStatement(INSERT_ROUTES);
        try {
            for (int i = 0; i <FROM.length; i++) {
                preparedStatement.setInt(1,FROM[i]);
                preparedStatement.setInt(2,TO[i]);
                preparedStatement.setInt(3,ID_PASS[i]);
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
    public void initTransportRoute() {
        PreparedStatement preparedStatement = getPreparedStatement(INSERT_ROUTE_TRANSPORT);

        try {

            for (int i = 0; i < NUMBER_OF_ROUTE.length; i++) {
                preparedStatement.setInt(1, NUMBER_OF_ROUTE[i]);
                preparedStatement.setInt(2, ID_TRANSPORT[i]);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            LOG.error("SQLException", e);
        } finally {

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
    public void createPath(PassangerPath passangerPath, StringBuilder text) {

        PreparedStatement preparedStatement = getPreparedStatement(INSERT_PATH);

        try {
            preparedStatement.setInt(1,passangerPath.getId());
            preparedStatement.setString(2, text.toString());
            preparedStatement.executeUpdate();


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
    public void create() {
    }

    @Override
    public List<PassangerPath> getAll() {
        List<PassangerPath> passangerPathList=new ArrayList<>();
        for (int i = 1; i <=this.getCount() ; i++) {
            passangerPathList.add(getById(i));
        }
        return passangerPathList;
    }


    @Override
    public int getCount() {
        PreparedStatement preparedStatement = getPreparedStatement(COUNT);
        int count=0;
        ResultSet  result = null;
        try {
            result = preparedStatement.executeQuery();
            result.next();
            count=result.getInt(COUNTROW);
            result.close();
        } catch (SQLException e) {
            LOG.error("SQLException", e);
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOG.error("SQLException", e);
            }
            connectionClose();
        }
        return count;
    }


    @Override
    public PassangerPath getById(int id) {
        PassangerPath passangerPath=new PassangerPath();
        passangerPath.setId(id);
        PreparedStatement preparedStatement = getPreparedStatement(PASSANGER_PATH);
        Passanger passanger;
        Station stationFrom=new Station();
        Station stationTo=new Station();
        int idPassenger=0;
        int addressFrom=0;
        int addressTo=0;

        try {
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                addressFrom=result.getInt(ADDRESS_FROM);
                addressTo=result.getInt(ADDRESS_TO);
                idPassenger=result.getInt(ID_PASSENGER);


            }

            stationFrom=new StationDao().getByStationId(addressFrom);
            passangerPath.setStationFrom(stationFrom);
            stationTo=new StationDao().getByStationId(addressTo);
            passangerPath.setStationTo(stationTo);
            passanger=new PassangerDao().getByStationId(idPassenger);
            passangerPath.setPassanger(passanger);


        } catch (SQLException e) {
            LOG.error("SQLException", e);
        } finally {
            connectionClose();
        }

        return passangerPath;
    }

    @Override
    public void create(PassangerPath entity) {

    }


}
