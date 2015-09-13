package com.antogeo.core.service;

import java.util.List;
import java.util.Observable;

/**
 * Created by George on 25/7/2015.
 */
public abstract class AbstractService<T> extends Observable {


    public abstract List<T> getAll();

    public abstract T insert(Object o);

    public abstract T update(Object o);

    public abstract List<T> getObjectsByUserId(long userId);

    public abstract T getObjectById(long objectId);

    public abstract boolean deleteObjectById(long objectId);

}
