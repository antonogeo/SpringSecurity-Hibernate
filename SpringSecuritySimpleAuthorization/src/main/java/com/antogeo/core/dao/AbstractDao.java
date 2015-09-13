package com.antogeo.core.dao;

import java.util.List;

/**
 * Created by George on 25/7/2015.
 */
public abstract class AbstractDao<T> {

    public abstract List<T> getAll();

    public abstract T insert(Object o);

    public abstract T update(Object o);

    public abstract List<T> getObjectsByUserId(long userId);

    public abstract T getObjectById(long objectId);

    public abstract boolean deleteObjectById(long objectId);

}
