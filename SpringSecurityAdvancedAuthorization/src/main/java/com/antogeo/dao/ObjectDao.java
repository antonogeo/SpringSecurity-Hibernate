package com.antogeo.dao;

import com.antogeo.entity.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ObjectDao extends AbstractDao {

    private static final String TABLE = "Object";
    private static final String CREATOR = "creator";

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public List<Object> getAll() {

        List<Object> objects = (List<Object>)(List<?>) hibernateUtil.selectAll(TABLE);
        return (List<Object>)(java.lang.Object)objects;
    }

    @Override
    public Object insert(java.lang.Object o) {
        return (Object) hibernateUtil.insert(o);
    }

    @Override
    public Object update(java.lang.Object o) {

        return (Object) hibernateUtil.update(o);
    }

    @Override
    public List<Object> getByUserId(long userId) {

        return (List<Object>) hibernateUtil.selectListById(TABLE, CREATOR, userId);
    }


    @Override
    public boolean deleteById(long objectId) {

        return hibernateUtil.deleteById(com.antogeo.entity.Object.class, objectId);
    }


    public HibernateUtil getHibernateUtil() {
        return hibernateUtil;
    }

    public void setHibernateUtil(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }
}
