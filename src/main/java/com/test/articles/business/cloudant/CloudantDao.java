package com.test.articles.business.cloudant;

import com.cloudant.client.api.Database;
import com.test.articles.business.Dao;
import com.test.articles.utils.exception.ArticlesRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public abstract class CloudantDao<T extends CloudantModel> implements Dao<T, String> {

    private final Database database;
    private final Class<T> type;

    @Autowired
    public CloudantDao(Database database, Class<T> type) {
        this.database = database;
        this.type = type;
    }

    @Override
    public String create(T entity) {
        return database.save(entity).getId();
    }

    @Override
    public T findOne(String id) {
        return database.find(type, id);
    }

    @Override
    public List<T> findAll() {
        try {
            return database.getAllDocsRequestBuilder()
                    .includeDocs(true)
                    .build()
                    .getResponse()
                    .getDocsAs(type);
        } catch (IOException e) {
            throw new ArticlesRuntimeException(e);
        }
    }

    @Override
    public boolean update(T entity) {
        return database.update(entity).getError() == null;
    }

    @Override
    public void delete(String id) {
        T entity = findOne(id);
        entity.setDeleted(true);
        database.update(entity);
    }

    @Override
    public void bulkUpdate(List<T> objects) {
        database.bulk(objects);
    }
}
