package com.antogeo.service;

import java.util.List;
import java.util.Observable;


public abstract class AbstractService<T> extends Observable {


    public abstract T insert(Object o);

    public abstract T update(Object o);

    public abstract List<T> getObjectsByUserId(long userId);

    public abstract boolean deleteObjectById(long objectId);

}
