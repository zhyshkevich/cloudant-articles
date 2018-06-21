package com.test.articles.business.article;

import com.cloudant.client.api.Database;
import com.test.articles.business.cloudant.CloudantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDao extends CloudantDao<ArticleModel>{

    @Autowired
    public ArticleDao(
            @Qualifier("articlesDatabase") Database articlesDatabase
    ){
        super(articlesDatabase, ArticleModel.class);
    }
}
