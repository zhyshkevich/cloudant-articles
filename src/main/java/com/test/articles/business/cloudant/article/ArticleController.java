package com.test.articles.business.cloudant.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

        if (!checkAuthorizationHeader(request)){
            return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(articleService.findOne(id), HttpStatus.OK);

    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> bulkUpdate(@RequestBody @Valid ArticlesRequest articles,
                                        HttpServletRequest request,
                                        BindingResult result){
        if (result.hasErrors()){
            return new ResponseEntity<String>("Bad request", HttpStatus.BAD_REQUEST);
        }
        if (!checkAuthorizationHeader(request)){
            return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

        }
        articleService.bulkUpdate(articles.getArticles(), request.getHeader("Authorization"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable String id,
                       @RequestBody ArticleModel articleModel,
                                    HttpServletRequest request){
        if (!checkAuthorizationHeader(request)){
            return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        articleModel.setId(id);
        articleService.update(articleModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id, HttpServletRequest request){

        if (!checkAuthorizationHeader(request)){
            return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        articleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
