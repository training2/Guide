package com.training2.guide.dao;

import com.training2.guide.dao.jdbc.mysql.JDBCFactory;
import com.training2.guide.dao.orm.mybatis.mysql.MybatisFactory;
import com.training2.guide.models.*;

public abstract class DaoFactory {

    public static final String JDBC = "jdbc";
    public static final String MYBATIS = "mybatis";
    private static DaoFactory daoFactory = null;

    protected DaoFactory() {
    }

    public abstract ICityDao<City, Integer> getCityDao();
    public abstract INeighborStationDao<NeighborStation, Integer> getNeighborStationDao();
    public abstract IPassangerDao<Passanger, Integer> getPassangerDao();
    public abstract IPassangerPathDao<PassangerPath, Integer> getPassangerPathDao();
    public abstract IRouteDao<Route, Integer> getRouteDao();
    public abstract IStationDao<Station, Integer> getStationDao();
    public abstract ITransportDao<AbstractTransport, Integer> getTransportDao();

    @Deprecated
    public static DaoFactory getDaoFactoryByType(String whichDao) {
        switch(whichDao.toLowerCase()) {
            case JDBC:
                daoFactory = JDBCFactory.getInstance();
                return daoFactory;
            case MYBATIS:
                daoFactory = MybatisFactory.getInstance();
                return daoFactory;
            default: return null;
        }
    }

    public static void initTypeOfDaoFactory(String whichDao) {
        switch(whichDao.toLowerCase()) {
            case JDBC:
                daoFactory = JDBCFactory.getInstance();
                break;
            case MYBATIS:
                daoFactory = MybatisFactory.getInstance();
                break;
            default: break;
        }
    }

    public static DaoFactory getInstance() {
        return daoFactory;
    }
}
