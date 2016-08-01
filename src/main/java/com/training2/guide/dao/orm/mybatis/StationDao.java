package com.training2.guide.dao.orm.mybatis;

import com.training2.guide.dao.IStationDao;
import com.training2.guide.models.Station;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StationDao implements IStationDao<Station, Integer> {

    @Override
    public List<Station> getAll() {
        return null;
    }

    @Override
    public Station getById(int id) {
        return null;
    }

    @Override
    public void create(Station entity) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Station getByStationId(Integer id) {
        Station station;
        SqlSession session = SessionFactory.getSession();
        station = session.selectOne("stationMapping.getById", id);
        session.commit();
        session.close();
        return station;
    }

    @Override
    public void create() {

    }
}
