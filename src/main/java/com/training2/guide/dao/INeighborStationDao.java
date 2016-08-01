package com.training2.guide.dao;

import java.util.List;

public interface INeighborStationDao<E, K> {

    public List<E> getAll();
    public E getById(int id);
    public void create(E entity);
    public int getCount();
    public E getByStationId(K id);
    public List<E> getListByStationId(K stationId);
    public void create();
}
