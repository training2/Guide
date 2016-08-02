package com.training2.guide.dao.orm.mybatis.mysql;

import com.training2.guide.dao.INeighborStationDao;
import com.training2.guide.models.NeighborStation;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class NeighborStationDao implements INeighborStationDao<NeighborStation, Integer> {

    public NeighborStationDao() {
    }


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
        SqlSession session  = SessionFactory.getSession();
        List<NeighborStation> neighborStationList = session.selectList("NeighborStationMapping.getListByStationId", stationId);
        session.commit();
        session.close();
        return neighborStationList;
    }

    @Override
    public void create() {

    }
}
