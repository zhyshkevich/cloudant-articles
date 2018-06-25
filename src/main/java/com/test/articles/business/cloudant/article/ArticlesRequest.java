package com.test.articles.business.cloudant.article;

import javax.validation.Valid;
import java.util.List;

public class ArticlesRequest {

    @Valid
    private List<ArticleModel> articles;

    public ArticlesRequest() {
    }

    public ArticlesRequest(List<ArticleModel> articles) {
        this.articles = articles;
    }

    public List<ArticleModel> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleModel> articles) {
        this.articles = articles;
    }
}
