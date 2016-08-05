/**
 * @author Kirill Bugrim on 20.07.2016.
 * @version 1.1
 */

package com.training2.guide.dao.jdbc.mysql;
import com.training2.guide.dao.IStationDao;
import com.training2.guide.dao.jdbc.mysql.utils.DAOFactory;
import com.training2.guide.models.City;
import com.training2.guide.models.Station;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirill on 20.07.2016.
 */
public class StationDao extends AbstractMySQLDao<Station, Integer> implements IStationDao<Station, Integer> {

    private static final Logger LOG = Logger.getLogger(DAOFactory.class);

    private static final String GET_ALL_BY_ADDRESS_ID = "select s.id, s.street, c.id as cityId, c.cityName from stations s inner join cities c on (s.city_id = c.id) where (s.id = ?)";
    final static String ID="id",CITY_ID="cityId",CITY_NAME="cityName",STREET="street",
            INSERT_STATION="INSERT INTO stations(Street,city_id)  VALUES (?, ?)";
    final static String[] STREETS={"Lenina str.","Mayakovskogo str.","Esenina str.","Nezavisimosti str.","Mogilevskaya str.","Kirova str.",
            "Frunze str.","Gagarina str.","Pobedy str.","Lazo str.","Chapaeva str.","Chkalova str.","Filimonova str","Kalinovskogo str.",
            "Nekrasova str.","Stroiteley str.","Lenina str.","Pushkina str."};
    final static int[] CITIES={1,1,1,1,1,1,2,2,2,2,2,2,1,1,1,2,2,2};

    final static List<Station> STATIONS=new ArrayList<>();

    public StationDao() {
    }


    @Override
    public void create() {

        PreparedStatement preparedStatement = getPreparedStatement(INSERT_STATION);

        int i=0;
        Station station;
        while(i!=STREETS.length){
            station=new Station();
            station.setId(CITIES[i]);
            station.setStreet(STREETS[i]);
            STATIONS.add(station);
            i++;
        }

        try {

            for (int j = 0; j <STATIONS.size(); j++) {

                preparedStatement.setString(1, STATIONS.get(j).getStreet());
                preparedStatement.setInt(2, STATIONS.get(j).getId());
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
     public Station getByStationId(Integer addressId) {
        Station station = new Station();
        City city = new City();
        PreparedStatement preparedStatement = getPreparedStatement(GET_ALL_BY_ADDRESS_ID);
        try {
            preparedStatement.setInt(1, addressId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                station.setId(result.getInt(ID));
                city.setId(result.getInt(CITY_ID));
                city.setCityName(result.getString(CITY_NAME));
                station.setStreet(result.getString(STREET));
                station.setCity(city);
                city = new City();
            }
            if (preparedStatement !=null) preparedStatement.close();
            if (result!=null) result.close();
        } catch (SQLException e) {
            LOG.error("SQLException", e);
        } finally {
            connectionClose();
        }
        return station;
    }

    @Override
    public List<Station> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Station getById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void create(Station entity) {

    }
}

