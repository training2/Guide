/**
 * @author Kirill Bugrim on 20.07.2016.
 * @version 1.1
 */
package com.training2.guide.dao.jdbc.mysql;
import com.training2.guide.dao.INeighborStationDao;
import com.training2.guide.dao.jdbc.mysql.utils.DAOFactory;
import com.training2.guide.models.NeighborStation;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class NeighborStationDao extends AbstractMySQLDao implements INeighborStationDao<NeighborStation, Integer> {

    private static final Logger LOG = Logger.getLogger(DAOFactory.class);

    private final static String ROUTE="insert into route values(?,?,?);";
    private final static int[] FROM={1,1,2,2,2,3,3,4,4,5,5,5,6,6,6,7,7,7,7,8,9,9,10,10,11,12,12,13,13,14,14,15,15,16,16,17,17,18,18};
    private final static int[] TO  ={5,6,5,6,3,2,4,3,6,1,2,7,1,2,4,5,8,9,10,7,7,12,7,12,12,9,10,14,15,13,15,14,13,17,18,16,18,16,17};
    private final static int[] DIST={8,9,3,4,6,6,2,2,11,8,3,270,9,4,11,270,3,8,6,3,8,2,6,5,11,2,5,9,4,9,4,4,4,3,4,3,8,4,8};

    @Override
    public List<NeighborStation> getAll() {
        return null;
    }

    @Override
    public NeighborStation getById(int id) {
        return null;
    }

    @Override
    public void create(NeighborStation entity) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public NeighborStation getByStationId(Integer id) {
        return null;
    }

    @Override
    public List<NeighborStation> getListByStationId(Integer stationId) {
        return null;
    }

    @Override
    public void create() {
        PreparedStatement preparedStatement = getPreparedStatement(ROUTE);
        try {

            for (int i = 0; i <FROM.length; i++) {
                preparedStatement.setInt(1,FROM[i]);
                preparedStatement.setInt(2,TO[i]);
                preparedStatement.setInt(3,DIST[i]);
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
}
