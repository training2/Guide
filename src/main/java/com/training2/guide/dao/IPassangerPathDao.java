package com.training2.guide.dao;

import java.util.List;

public interface IPassangerPathDao<E, K> {

    public List<E> getAll();
    public E getById(int id);
    public int getCount();
    public void create();
    public void createPath();
    public void initTransportRoute();
    public void createPath(E passangerPath, StringBuilder text);
}
