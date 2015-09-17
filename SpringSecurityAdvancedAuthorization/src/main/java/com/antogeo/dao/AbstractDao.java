package com.antogeo.dao;

import java.util.List;


public abstract class AbstractDao<T> {

    public abstract List<T> getAll();

    public abstract T insert(Object o);

    public abstract List<T> getByUserId(long userId);

}
