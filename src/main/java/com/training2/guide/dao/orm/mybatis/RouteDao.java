package com.training2.guide.dao.orm.mybatis;

import com.training2.guide.dao.INeighborStationDao;
import com.training2.guide.dao.IRouteDao;
import com.training2.guide.dao.IStationDao;
import com.training2.guide.models.NeighborStation;
import com.training2.guide.models.Route;
import com.training2.guide.models.Station;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RouteDao implements IRouteDao<Route, Integer> {

    private IStationDao<Station, Integer> dao;
    private INeighborStationDao<NeighborStation, Integer> neighborStationDao;

    public RouteDao() {
        this.dao = new StationDao();
        this.neighborStationDao = new NeighborStationDao();
    }

    @Override
    public List<Route> getAll() {
        return null;
    }

    @Override
    public Route getById(int id) {
        return null;
    }

    @Override
    public void create(Route entity) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Route getByStationId(Integer id) {
        Route route = new Route();
        SqlSession session = SessionFactory.getSession();
        route.setStation(dao.getByStationId(id));
        route.setNeighborStationList(neighborStationDao.getListByStationId(id));
        session.commit();
        session.close();
        return route;
    }

    @Override
    public List<Route> getListByStationId(Integer stationId) {
        return null;
    }

    @Override
    public void create() {

    }
}
