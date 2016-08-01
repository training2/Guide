package com.training2.guide.dao.orm.mybatis;

import com.training2.guide.dao.ICityDao;
import com.training2.guide.models.City;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CityDao implements ICityDao<City, Integer> {

    @Override
    public List<City> getAll() {
        List<City> cityList;
        SqlSession session = SessionFactory.getSession();
        cityList = session.selectList("cityMapping.getAllCities");
        session.commit();
        session.close();
        return cityList;
    }

    @Override
    public City getById(int id) {
        City city;
        SqlSession session = SessionFactory.getSession();
        city = session.selectOne("cityMapping.getCityById", id);
        session.commit();
        session.close();
        return city;
    }

    @Override
    public void create(City entity) {
        SqlSession session = SessionFactory.getSession();
        session.insert("cityMapping.cityInsert", entity);
        session.commit();
        session.close();
    }

    @Override
    public int getCount() {
        SqlSession session = SessionFactory.getSession();
        Integer count = session.selectOne("cityMapping.getCount");
        session.commit();
        session.close();
        return count;
    }

    @Override
    public City getByStationId(Integer id) {
        City city;
        SqlSession session = SessionFactory.getSession();
        city = session.selectOne("cityMapping.getByStationId", id);
        session.commit();
        session.close();
        return city;
    }

    @Override
    public List<City> getListByStationId(Integer stationId) {
        return null;
    }

    @Override
    public void create() {

    }
}
