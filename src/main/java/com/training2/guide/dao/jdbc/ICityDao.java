package com.training2.guide.dao.jdbc;

import java.util.List;

public interface ICityDao<E, K> {

    public List<E> getAll();
    public E getById(int id);
    public int getCount();
    public E getByStationId(K id);
    public List<E> getListByStationId(K stationId);
    public void create();
}
