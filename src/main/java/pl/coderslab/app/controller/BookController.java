package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.dao.BookDao;
import pl.coderslab.app.dao.PublisherDao;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;

@Controller
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @RequestMapping("/book/add")
    @ResponseBody
    public String saveBook() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setDescription("How to Java");
        book.setRating(4);
        bookDao.saveBook(book);
        return "Id dodanej książki to:"
                + book.getId();
    }
    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }
    @RequestMapping("/book/update/{id}/{title}/{description}/{rating}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title, @PathVariable String description, @PathVariable Integer rating) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        book.setDescription(description);
        book.setRating(rating);
        bookDao.update(book);
        return book.toString();
    }
    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "deleted";
    }
    @GetMapping(value="/addBookWithPublisher")
    @ResponseBody
    public Publisher createWithPublisher(){
        Book book = new Book();
        book.setTitle("nowa ksiazka");
        book.setDescription("Z nowym opisem");
        bookDao.saveBook(book);
        Publisher publisher = new Publisher();
        publisher.setName("Nowy publisher");
        publisher.getBooks().add(book);
        publisherDao.save(publisher);
        return publisher;
    }

    @GetMapping(value="/addBookWithAuthors")
    @ResponseBody
    public Book createWithAuthors(){
        Book book = new Book();
        book.setTitle("nowa ksiazka");
        book.setDescription("Z nowy opisem");
        book.setRating(10);
        Author author1 = new Author();
        author1.setFirstName("Autor1Name");
        author1.setLastName("Autor1LastName");
        Author author2 = new Author();
        author2.setFirstName("Autor2Name");
        author2.setLastName("Autor2LastName");
        bookDao.saveBook(book);
        author1.getBooks().add(book);
        author2.getBooks().add(book);
        authorDao.saveAuthor(author1);
        authorDao.saveAuthor(author2);
//        book.getAuthors().add(author1);
//        book.getAuthors().add(author2);
        return book;
    }
}
