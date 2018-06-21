package com.test.articles.article;

import com.test.articles.business.article.ArticleDao;
import com.test.articles.business.article.ArticleModel;
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
            model.setText("22222222222");
        }

        articleDao.bulkUpdate(models);
    }


}
