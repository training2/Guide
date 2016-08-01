package com.training2.guide.dao.orm.mybatis;

import com.training2.guide.dao.INeighborStationDao;
import com.training2.guide.dao.IStationDao;
import com.training2.guide.models.NeighborStation;
import com.training2.guide.models.Station;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class NeighborStationDao implements INeighborStationDao<NeighborStation, Integer> {

    private IStationDao<Station, Integer> dao;

    public NeighborStationDao() {
        this.dao = new StationDao();
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
        Station currentStation = dao.getByStationId(stationId);
        SqlSession session  = SessionFactory.getSession();
        List<NeighborStation> neighborStationList = session.selectList("NeighborStationMapping.getListByStationId", currentStation);
        for(NeighborStation neighborStation: neighborStationList) {
            neighborStation.setStation(currentStation);
        }
        session.commit();
        session.close();
        return neighborStationList;
    }

    @Override
    public void create() {

    }
}
