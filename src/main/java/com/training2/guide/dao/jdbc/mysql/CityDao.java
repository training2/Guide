/**
 * @author Kirill Bugrim on 20.07.2016.
 * version 1.1
 */

package com.training2.guide.dao.jdbc.mysql;

import com.training2.guide.dao.ICityDao;
import com.training2.guide.models.City;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CityDao extends AbstractMySQLDao implements ICityDao<City, Integer> {

    private static final Logger LOG = Logger.getLogger(CityDao.class);

    private static final String GET_CITY_BY__ID ="SELECT * FROM guide.cities where id=?",
            INSERT_CITY="insert ignore into cities(cityName) values(?)", CITYNAME="cityName";
    final static String[] city={"Minsk","Vitebsk"};

    @Override
    public void create() {
        PreparedStatement preparedStatement = getPreparedStatement(INSERT_CITY);

        try {

            for (int i = 0; i <city.length; i++) {

                preparedStatement.setString(1, city[i]);
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
    public City getByStationId(Integer id) {
        City city=new City();
        PreparedStatement preparedStatement = getPreparedStatement(GET_CITY_BY__ID);

        try {
            city.setId(id);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String cityName=resultSet.getString(CITYNAME);
                city.setCityName(cityName);
            }

            resultSet.close();
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

        return city;
    }

    @Override
    public List<City> getListByStationId(Integer stationId) {
        return null;
    }

    @Override
    public List<City> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException();
    }

    @Override
    public City getById(int id) {
        throw new UnsupportedOperationException();
    }
}
