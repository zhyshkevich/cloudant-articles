package com.test.articles.business.cloudant;

import com.test.articles.business.Service;

import java.util.List;

public class CloudantService<T extends CloudantModel, D extends CloudantDao<T>> implements Service<T, String> {

    private D dao;

    public CloudantService(D dao){
        this.dao = dao;
    }

    @Override
    public String create(T entity) {
        return dao.create(entity);
    }

    @Override
    public T findOne(String id) {
        return dao.findOne(id);
    }

    @Override
    public boolean update(String id) {
        return dao.update(findOne(id));
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public List<T> findAll() {
        return dao.findAll();
    }

    @Override
    public void bulkUpdate(List<T> objects) {
        dao.bulkUpdate(objects);
    }
}
