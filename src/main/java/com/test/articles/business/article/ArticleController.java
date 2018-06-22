package com.test.articles.business.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable String id,
                       @RequestBody ArticleModel articleModel){

        articleModel.setId(id);
        articleService.update(articleModel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        articleService.delete(id);
    }

}
