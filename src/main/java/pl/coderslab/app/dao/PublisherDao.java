package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    EntityManager entityManager;
    public void save (Publisher publisher) {
        entityManager.persist(publisher);
    }
    public void delete (Publisher publisher) {
        entityManager.remove(publisher);
    }
    public Publisher findById (Long id) {
        return entityManager.find(Publisher.class, id);
    }
    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }
}