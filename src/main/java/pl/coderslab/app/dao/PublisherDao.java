package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

    public void savePublisher(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public void updatePublisher(Publisher publisher) {
        entityManager.merge(publisher);
    }

    public Publisher findPublisherById(long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void deletePublisher(Publisher publisher) {
        entityManager.remove(entityManager.contains(publisher) ? publisher : entityManager.merge(publisher));
    }

    public List<Publisher> findAllPublishers(){
        Query query = entityManager.createQuery("SELECT p FROM Publisher p");
        List<Publisher> publishers = query.getResultList();

        return publishers;
    }
}