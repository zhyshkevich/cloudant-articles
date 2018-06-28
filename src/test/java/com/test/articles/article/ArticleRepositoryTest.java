package com.test.articles.article;

import com.test.articles.business.cloudant.article.ArticleRepository;
import com.test.articles.business.cloudant.article.ArticleModel;
import com.test.articles.business.cloudant.article.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ArticleService articleService;

    @Test
    public void testSave(){
        ArticleModel articleModel = new ArticleModel();

        articleModel.setTitle("test");
        articleModel.setText("test");
        articleModel.setDateEdited("asdasd");
        articleModel.setDatePublished("safasdf");
        articleModel.setEditor("asdasd");
        articleModel.setPublisher("asdasd");

        articleRepository.create(articleModel);
    }

    @Test
    public void testFind(){
        ArticleModel articleModel = articleRepository.findOne("9d4bf8d077914f4eba15a831f4db30f2");
        System.out.println(articleModel);
    }

    @Test
    public void testFindAll(){
        List<ArticleModel> models = articleService.findAll();
        for (ArticleModel model: models){
            System.out.println(model);
        }
    }

    @Test
    public void testUpdate(){
        ArticleModel articleModel = articleRepository.findOne("9d4bf8d077914f4eba15a831f4db30f2");
        articleModel.setPublisher("11111111111");
        articleRepository.update(articleModel);
    }

    @Test
    public void testDelete(){
        ArticleModel articleModel = new ArticleModel();
        String id = articleRepository.create(articleModel);
        articleRepository.delete(id);
    }

    @Test
    public void testBulkUpdate(){
        List<ArticleModel> models = articleRepository.findAll();
        for (ArticleModel model: models){
            model.setText("test bulk update !!!!!!!!");
        }
        ArticleModel model = new ArticleModel();
        model.setText("TEST!!!!!!!!!!");
        models.add(model);

        articleRepository.bulkUpdate(models);
    }

//    @Test
//    public void testBulkUpdateService(){
//        List<ArticleModel> models = articleService.findAll();
//        for (ArticleModel model: models){
//            model.setText("2222");
//        }
//        ArticleModel model = new ArticleModel();
//        model.setText("111");
//        models.add(model);
//
//        articleService.bulkUpdate(models);
//    }

    @Test
    public void testGetByUUID(){
        System.out.println(articleService.findByUUID("3844583b-3661-4365-ba43-0b0f31dd9961"));
    }

}
