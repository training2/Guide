package com.training2.guide.dao.orm.mybatis;

import com.training2.guide.dao.IPassangerDao;
import com.training2.guide.models.Passanger;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PassangerDao implements IPassangerDao<Passanger, Integer> {

    @Override
    public List<Passanger> getAll() {
        return null;
    }

    @Override
    public Passanger getById(int id) {
        return null;
    }

    @Override
    public void create(Passanger entity) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Passanger getByStationId(Integer id) {
        Passanger passanger;
        SqlSession session = SessionFactory.getSession();
        passanger = session.selectOne("PassangerMapping.getById", id);
        session.commit();
        session.close();
        return passanger;
    }

    @Override
    public List<Passanger> getListByStationId(Integer stationId) {
        return null;
    }

    @Override
    public void create() {

    }
}
