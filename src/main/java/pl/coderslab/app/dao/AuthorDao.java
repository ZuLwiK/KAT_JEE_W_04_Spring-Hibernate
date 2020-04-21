package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveAuthor (Author author) {
        entityManager.persist(author);
    }
    public void delete (Author author) {
        entityManager.remove(author);
    }
    public Author findById (Long id) {
        return entityManager.find(Author.class, id);
    }
    public void update(Author author) {
        entityManager.merge(author);
    }
}