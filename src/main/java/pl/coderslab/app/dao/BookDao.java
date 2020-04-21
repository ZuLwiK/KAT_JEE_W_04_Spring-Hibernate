package pl.coderslab.app.dao;
import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Book;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveBook (Book book) {
        entityManager.persist(book);
    }
    public void delete (Book book) {
        entityManager.remove(book);
    }
    public Book findById (Long id) {
        return entityManager.find(Book.class, id);
    }
    public void update(Book book) {
        entityManager.merge(book);
    }
}
