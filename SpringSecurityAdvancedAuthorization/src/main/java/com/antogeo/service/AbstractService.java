package com.antogeo.service;

import java.util.List;
import java.util.Observable;


public abstract class AbstractService<T> extends Observable {

    public abstract List<T> getAll();

    public abstract T insert(Object o);

    public abstract List<T> getByUserId(long userId);

}
