package pl.coderslab.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dao.*;
import pl.coderslab.app.entity.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, PersonDao personDao, PersonDetailsDao personDetailsDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
        this.authorDao = authorDao;
    }
    @GetMapping(value = "/all")
    public String getAll(Model model) {
        List<Book> books = bookDao.findAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editForm(Model model, @PathVariable long id) {
        model.addAttribute("book", bookDao.findBookById(id));
        return "bookForm";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@Valid Book book, BindingResult result){
        if (result.hasErrors()){
            return "/edit/{id}";
        }
        bookDao.updateBook(book);
        return "redirect:/book/all";

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@Valid Book book, BindingResult result){
        if (result.hasErrors()){
            return "/all";
        }
        bookDao.deleteBook(book);
        return "redirect:/book/all";
    }

    @ModelAttribute("publishers")
    public List<Publisher> publisherList(){
        return publisherDao.findAllPublishers();
    }

    @ModelAttribute("authors")
    public List<Author> authorList(){return authorDao.findAllAuthors();}

    //    @GetMapping(value = "/all")
//    @ResponseBody
//    public List<Book> getAll(){
//        List<Book> books = bookDao.findAllBooks();
//
//        return books;
//    }



//    @PutMapping("/edit/{id}")
//    public String update(@PathVariable Long id, @RequestBody Book book, Model model) {
//        Book bookInDb = bookDao.findBookById(id);
//        bookInDb.setTitle(book.getTitle());
//        bookInDb.setRating(book.getRating());
//        bookInDb.setDescription(book.getDescription());
//        bookDao.updateBook(bookInDb);
//        List<Book> books = bookDao.findAll();
//        model.addAttribute("books", books);
//        return "books";
//    }

    @GetMapping(value = "/rating/{rating}")
    @ResponseBody
    public List<Book> findWithRatingGreaterThen(@PathVariable Integer rating) {
        List<Book> books = bookDao.findAllWithRatingGreaterThen(rating);

        return books;
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Book book(@PathVariable Long id) {
        return bookDao.findBookById(id);
    }


    @GetMapping(value = "/addBookWithPublisher")
    @ResponseBody
    public Publisher createWithPublisher() {
        Book book = new Book();
        book.setTitle("Nowa ksiazka");
        book.setDescription("Z nowym opisem");

        bookDao.saveBook(book);

        Publisher publisher = new Publisher();
        publisher.setName("Nowy publisher");


        publisherDao.savePublisher(publisher);

        return publisher;

    }

    @GetMapping(value = "/addBookWithPublisher2")
    @ResponseBody
    public String createWithPublisher2() {
        Book book = new Book();
        book.setTitle("Nowa ksiazka");
        book.setDescription("Z nowym opisem");

        bookDao.saveBook(book);

        Publisher publisher = new Publisher();
        publisher.setName("Nowy publisher");
        publisher.getBooks().add(book);

        publisherDao.savePublisher(publisher);

        return publisher.toString();

    }

    @PostMapping("")
    @ResponseBody
    public Book create(@RequestBody Book book) {

        bookDao.saveBook(book);

        return book;
    }


//    @PutMapping("/{id}")
//    @ResponseBody
//    public Book update(@PathVariable Long id, @RequestBody  Book book){
//        Book bookInDb = bookDao.findBookById(id);
//
//        bookInDb.setTitle(book.getTitle());
//        bookInDb.setRating(book.getRating());
//        bookInDb.setDescription(book.getDescription());
//
//        bookDao.updateBook(bookInDb);
//
//        return bookInDb;
//    }




    @GetMapping("/userTest2")
    public void createUser2() {
        Person person = new Person();
        person.setEmail("nowy mail");

        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("Tomasz");

        personDetailsDao.save(personDetails);

        person.setPersonDetails(personDetails);
        personDao.save(person);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processForm(@ModelAttribute Book book) {
        bookDao.saveBook(book);
        return "redirect:/book/list";
    }

}