package com.antogeo.dao;

import java.util.List;


public abstract class AbstractDao<T> {

    public abstract List<T> getAll();

    public abstract T insert(Object o);

    public abstract T update(Object o);

    public abstract List<T> getByUserId(long userId);

    public abstract boolean deleteById(long objectId);

}
