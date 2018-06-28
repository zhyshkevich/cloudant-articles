package com.test.articles.business.cloudant.article;

import com.test.articles.utils.DateGenerator;
import com.test.articles.utils.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private ArticleRepository repository;
    private DateGenerator dateGenerator;
    private UuidGenerator uuidGenerator;

    @Autowired
    public ArticleService(ArticleRepository articleRepository,
                          DateGenerator dateGenerator,
                          UuidGenerator uuidGenerator){
        this.repository = articleRepository;
        this.dateGenerator = dateGenerator;
        this.uuidGenerator = uuidGenerator;
    }

    public String create(ArticleModel entity) {
        return repository.create(entity);
    }

    public ArticleModel findOne(String id) {
        return repository.findOne(id);
    }

    public ArticleModel findByUUID(String id){
        return repository.findByUUID(id);
    }

    public boolean update(ArticleModel entity) {
        return repository.update(entity);
    }

    public void delete(String id) {
        repository.delete(id);
    }

    public List<ArticleModel> findAll() {
        return repository.findAll();
    }

    public void bulkUpdate(List<ArticleModel> objects, String email) {
        for (ArticleModel model: objects){
            if (model.getUuid() == null){
                model.setUuid(uuidGenerator.generateUUID());
                model.setDatePublished(dateGenerator.generateDate());
                model.setDateEdited(dateGenerator.generateDate());
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
        repository.bulkUpdate(objects);
    }

}
