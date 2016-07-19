package com.training2.guide.jdbc;

import java.util.List;

public abstract class AbstractDao<E, K> {

    public abstract List<E> getAll();

}
