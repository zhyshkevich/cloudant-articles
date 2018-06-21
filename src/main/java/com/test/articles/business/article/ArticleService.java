package com.test.articles.business.article;

import com.test.articles.business.cloudant.CloudantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService extends CloudantService<ArticleModel, ArticleDao> {

    private ArticleDao articleDao;

    @Autowired
    public ArticleService(ArticleDao articleDao){
        super(articleDao);
    }

}
