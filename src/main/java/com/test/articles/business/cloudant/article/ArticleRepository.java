package com.test.articles.business.cloudant.article;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.views.Key;
import com.test.articles.utils.exception.ArticlesRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

import static com.cloudant.client.api.views.SettableViewParameters.STALE_OK;

@Repository
public class ArticleRepository {

    private static final Logger LOG = LoggerFactory.getLogger(ArticleModel.class);

    private final Database database;
    private final String getByUUIDview;
    private final String getAll;

    public ArticleRepository(@Value("${cloudant.articles.dbname}") String databaseName,
                             @Value("${cloudant.articles.view.getByUUID}") String getByUUIDview,
                             @Value("${cloudant.articles.view.getAll}") String getAll,
                             CloudantClient cloudantClient) {
        this.database = cloudantClient.database(databaseName, true);
        this.getByUUIDview = getByUUIDview;
        this.getAll = getAll;
    }


    public String create(ArticleModel entity) {
        return database.save(entity).getId();
    }

    public ArticleModel findOne(String id) {
        return database.find(ArticleModel.class, id);
    }

    public ArticleModel findByUUID(String id) {
        List<ArticleModel> models = null;
        try {
            models = database.getViewRequestBuilder(getByUUIDview, getByUUIDview)
                    .newRequest(Key.Type.STRING, ArticleModel.class)
                    .stale(STALE_OK)
                    .includeDocs(true)
                    .keys(id)
                    .build()
                    .getResponse()
                    .getDocsAs(ArticleModel.class);
        } catch (IOException e) {
            LOG.error("Cannot connect to the database", e);
        }
        return models.get(0);
    }


    public List<ArticleModel> findAll() {
        try {
            return database.getViewRequestBuilder(getAll, getAll)
                    .newRequest(Key.Type.STRING, ArticleModel.class)
                    .stale(STALE_OK)
                    .includeDocs(true)
                    .build()
                    .getResponse()
                    .getDocsAs(ArticleModel.class);
        } catch (IOException e) {
            throw new ArticlesRuntimeException(e);
        }
    }

    public boolean update(ArticleModel entity) {
        return database.update(entity).getError() == null;
    }

    public void delete(String id) {
        ArticleModel entity = findOne(id);
        entity.setDeleted(true);
        database.update(entity);
    }

    public void bulkUpdate(List<ArticleModel> objects) {
        database.bulk(objects);
    }
}
