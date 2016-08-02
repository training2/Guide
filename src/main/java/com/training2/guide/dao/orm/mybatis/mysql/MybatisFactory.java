package com.training2.guide.dao.orm.mybatis.mysql;

import com.training2.guide.dao.*;
import com.training2.guide.models.*;

public class MybatisFactory extends DaoFactory {

    private static MybatisFactory mybatisFactory = null;

    private MybatisFactory() {
    }

    @Override
    public ICityDao<City, Integer> getCityDao() {
        return new CityDao();
    }

    @Override
    public INeighborStationDao<NeighborStation, Integer> getNeighborStationDao() {
        return new NeighborStationDao();
    }

    @Override
    public IPassangerDao<Passanger, Integer> getPassangerDao() {
        return new PassangerDao();
    }

    @Override
    public IPassangerPathDao<PassangerPath, Integer> getPassangerPathDao() {
        return new PassangerPathDao();
    }

    @Override
    public IRouteDao<Route, Integer> getRouteDao() {
        return new RouteDao();
    }

    @Override
    public IStationDao<Station, Integer> getStationDao() {
        return new StationDao();
    }

    @Override
    public ITransportDao<AbstractTransport, Integer> getTransportDao() {
        return new TransportDao();
    }

    public static MybatisFactory getInstance() {
        if(mybatisFactory == null) {
            mybatisFactory = new MybatisFactory();
        }
        return mybatisFactory;
    }
}
