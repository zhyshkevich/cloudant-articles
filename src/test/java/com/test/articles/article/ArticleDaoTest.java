package com.test.articles.article;

import com.test.articles.business.article.ArticleDao;
import com.test.articles.business.article.ArticleModel;
import com.test.articles.business.article.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleDaoTest {

    @Autowired
    ArticleDao articleDao;

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

        articleDao.create(articleModel);
    }

    @Test
    public void testFind(){
        ArticleModel articleModel = articleDao.findOne("9d4bf8d077914f4eba15a831f4db30f2");
        System.out.println(articleModel);
    }

    @Test
    public void testFindAll(){
        List<ArticleModel> models = articleDao.findAll();
        for (ArticleModel model: models){
            System.out.println(model);
        }
    }

    @Test
    public void testUpdate(){
        ArticleModel articleModel = articleDao.findOne("9d4bf8d077914f4eba15a831f4db30f2");
        articleModel.setPublisher("11111111111");
        articleDao.update(articleModel);
    }

    @Test
    public void testDelete(){
        ArticleModel articleModel = new ArticleModel();
        String id = articleDao.create(articleModel);
        articleDao.delete(id);
    }

    @Test
    public void testBulkUpdate(){
        List<ArticleModel> models = articleDao.findAll();
        for (ArticleModel model: models){
            model.setText("test bulk update !!!!!!!!");
        }
        ArticleModel model = new ArticleModel();
        model.setText("TEST!!!!!!!!!!");
        models.add(model);

        articleDao.bulkUpdate(models);
    }

    @Test
    public void testBulkUpdateService(){
        List<ArticleModel> models = articleService.findAll();
        for (ArticleModel model: models){
            model.setText("2222");
        }
        ArticleModel model = new ArticleModel();
        model.setText("111");
        models.add(model);

        articleService.bulkUpdate(models);
    }

}
