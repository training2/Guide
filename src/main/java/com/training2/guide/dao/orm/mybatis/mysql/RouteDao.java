package com.training2.guide.dao.orm.mybatis.mysql;

import com.training2.guide.dao.IRouteDao;
import com.training2.guide.models.Route;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RouteDao implements IRouteDao<Route, Integer> {

    public RouteDao() {
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
        route.setNeighborStationList(session.selectList("RouteMapping.getByStationId", id));
        route.setStation(route.getNeighborStationList().get(0).getStation());
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
