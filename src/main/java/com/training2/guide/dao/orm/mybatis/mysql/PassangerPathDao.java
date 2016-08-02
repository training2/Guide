package com.training2.guide.dao.orm.mybatis.mysql;

import com.training2.guide.dao.IPassangerPathDao;
import com.training2.guide.models.PassangerPath;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassangerPathDao implements IPassangerPathDao<PassangerPath, Integer> {

    @Override
    public List<PassangerPath> getAll() {
        List<PassangerPath> passangerPathList;
        SqlSession session = SessionFactory.getSession();
        passangerPathList = session.selectList("PassangerPathMapping.getAll");
        session.commit();
        session.close();
        return passangerPathList;
    }

    @Override
    public PassangerPath getById(int id) {
        return null;
    }

    @Override
    public void create(PassangerPath entity) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public void create() {

    }

    @Override
    public void createPath() {
    }

    @Override
    public void initTransportRoute() {

    }

    @Override
    public void createPath(PassangerPath passangerPath, StringBuilder text) {
        Map<String, Object> map = new HashMap<>();
        SqlSession session = SessionFactory.getSession();
        map.put("orderId", passangerPath.getId());
        map.put("route", text.toString());
        session.insert("PassangerPathMapping.insertPassangerPath", map);
        session.commit();
        session.close();
    }
}
