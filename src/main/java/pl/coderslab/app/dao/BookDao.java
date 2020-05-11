package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;


    public List<Book> findAll(){
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        List<Book> books = query.getResultList();

        return books;
    }
    public List<Book> findAllBookPropostitions(){
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.proposition=true");
        List<Book> propostitions = query.getResultList();
        return propostitions;
    }

    public List<Book> findAllWithRatingGreaterThen(Integer rating){
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.rating > :rating");
        query.setParameter("rating", rating);

        List<Book> books = query.getResultList();

        return books;
    }


    public void saveBook(Book book){
        entityManager.persist(book);
    }

    public void updateBook(Book book){

        entityManager.merge(book);
    }

    public Book findBookById(Long id){
        return entityManager.find(Book.class, id);
    }

    public void deleteBook(Book book) {
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }
}
