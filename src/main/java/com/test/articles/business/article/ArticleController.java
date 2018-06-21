package com.test.articles.business.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    @GetMapping
    public List<ArticleModel> getAll(){
        return articleService.findAll();
    }

    @GetMapping("/{id}")
    public ArticleModel getById(@PathVariable String id){
        return articleService.findOne(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void bulkUpdate(@RequestBody List<ArticleModel> models){
        for (ArticleModel model: models){
            System.out.println(model);
        }
        articleService.bulkUpdate(models);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id){
        articleService.update(id);
    }

}
