package com.training2.guide.dao.orm.mybatis.mysql;

import com.training2.guide.dao.ITransportDao;
import com.training2.guide.models.AbstractTransport;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class TransportDao implements ITransportDao<AbstractTransport, Integer> {

    @Override
    public List<AbstractTransport> getAll() {
        return null;
    }

    @Override
    public AbstractTransport getById(int id) {
        return null;
    }

    @Override
    public void create(AbstractTransport entity) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public List<AbstractTransport> getListByStationId(Integer stationId) {
        List<AbstractTransport> transportList = new ArrayList<>();
        SqlSession session = SessionFactory.getSession();
        transportList.addAll(session.selectList("transportMapping.getTrolleybusListByStationId", stationId));
        transportList.addAll(session.selectList("transportMapping.getTrainListByStationId", stationId));
        transportList.addAll(session.selectList("transportMapping.getTramListByStationId", stationId));
        transportList.addAll(session.selectList("transportMapping.getBusListByStationId", stationId));
        for(AbstractTransport transport: transportList) {
            transport.setStationList(session.selectList("transportMapping.getStationListByTransportId", transport.getId()));
        }
        session.commit();
        session.close();
        return transportList;
    }

    @Override
    public void create() {

    }

    @Override
    public String getTransportTypeById(Integer id) {
        SqlSession session = SessionFactory.getSession();
        String transportType = session.selectOne("transportMapping.getTransportTypeById", id);
        session.commit();
        session.close();
        return transportType;
    }
}
