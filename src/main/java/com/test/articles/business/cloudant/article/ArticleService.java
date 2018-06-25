package com.test.articles.business.cloudant.article;

import com.test.articles.utils.DateGenerator;
import com.test.articles.utils.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private ArticleDao dao;

    @Autowired
    public ArticleService(ArticleDao articleDao){
        this.dao = articleDao;
    }

    public String create(ArticleModel entity) {
        return dao.create(entity);
    }

    public ArticleModel findOne(String id) {
        return dao.findOne(id);
    }

    public ArticleModel findByUUID(String id){
        return dao.findByUUID(id);
    }

    public boolean update(ArticleModel entity) {
        return dao.update(entity);
    }

    public void delete(String id) {
        dao.delete(id);
    }

    public List<ArticleModel> findAll() {
        return dao.findAll();
    }

    public void bulkUpdate(List<ArticleModel> objects, String email) {
        for (ArticleModel model: objects){
            if (model.getUuid() == null){
                model.setUuid(UuidGenerator.generateUUID());
                model.setDatePublished(DateGenerator.generateDate());
                model.setDateEdited(DateGenerator.generateDate());
                model.setPublisher(email);
            } else {
                ArticleModel cloudantModel = findByUUID(model.getUuid());
                model.setId(cloudantModel.getId());
                model.setRev(cloudantModel.getRev());
                if (cloudantModel.getPublisher() == null) {
                    model.setPublisher(email);
                }
            }
        }
        for (ArticleModel model: objects){
            System.out.println(model);
        }
        dao.bulkUpdate(objects);
    }

}
