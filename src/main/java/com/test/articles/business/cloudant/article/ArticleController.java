package com.test.articles.business.cloudant.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    private Boolean checkAuthorizationHeader(HttpServletRequest request){
        String email = request.getHeader("Authorization");
        if (email == null){
            return false;
        }
        return true;
    }

    @GetMapping
    public ResponseEntity<?> getAll(HttpServletRequest request){
        if (checkAuthorizationHeader(request)){
            return new ResponseEntity<>(articleService.findAll(), HttpStatus.OK);
        }
        return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id, HttpServletRequest request){

        if (checkAuthorizationHeader(request)){
            return new ResponseEntity<>(articleService.findOne(id), HttpStatus.OK);
        }
        return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> bulkUpdate(@RequestBody List<ArticleModel> models, HttpServletRequest request){
        if (checkAuthorizationHeader(request)){
            articleService.bulkUpdate(models);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable String id,
                       @RequestBody ArticleModel articleModel,
                                    HttpServletRequest request){
        if (checkAuthorizationHeader(request)){
            articleModel.setId(id);
            articleService.update(articleModel);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id, HttpServletRequest request){

        if (checkAuthorizationHeader(request)){
            articleService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
    }

}
