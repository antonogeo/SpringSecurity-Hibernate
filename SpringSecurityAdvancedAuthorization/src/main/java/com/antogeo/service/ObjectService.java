package com.antogeo.service;

import com.antogeo.dao.ObjectDao;
import com.antogeo.entity.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("objectService")
public class ObjectService extends AbstractService {

    @Autowired
    private ObjectDao objectDao;


    @Transactional(readOnly = false)
    @Override
    public Object insert(java.lang.Object o) {

        Object object = objectDao.insert(o);

        return object;
    }


    @Transactional(readOnly = false)
    @Override
    public Object update(java.lang.Object o) {

        Object object = objectDao.update(o);

        return object;
    }


    @Transactional(readOnly = true)
    @Override
    public List<com.antogeo.entity.Object> getObjectsByUserId(long userId) {

        return objectDao.getByUserId(userId);
    }


    @Transactional(readOnly = false)
    @Override
    public boolean deleteObjectById(long objectId) {

        return objectDao.deleteById(objectId);
    }


  /*  public boolean updateObjectValue(long objectId){

        Object object =

    }*/


    public void setObjectDao(ObjectDao objectDao) {
        this.objectDao = objectDao;
    }
}
