package com.antogeo.service;

import com.antogeo.dao.ObjectDao;
import com.antogeo.entity.Object;
import com.antogeo.entity.User;
import com.antogeo.form.ObjectForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

@Service("objectService")
@EnableTransactionManagement
public class ObjectService extends AbstractService {

    @Autowired
    private ObjectDao objectDao;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    @Override
    public List<Object> getAll() {

        return objectDao.getAll();
    }

    @Transactional(readOnly = false)
    @Override
    public Object insert(java.lang.Object o) {

        Object object = objectDao.insert(o);

        return object;
    }


    @Transactional(readOnly = true)
    @Override
    public List<com.antogeo.entity.Object> getByUserId(long userId) {

        return objectDao.getByUserId(userId);
    }


    @Transactional(readOnly = false)
    public Object insertObject(ObjectForm form, Principal principal) {

        User user = userService.getUserByUsername(principal.getName());

        Object object = new Object(form.getName(), form.getValue(), user);

        object = insert(object);

        return object;
    }


    public void setObjectDao(ObjectDao objectDao) {
        this.objectDao = objectDao;
    }
}
