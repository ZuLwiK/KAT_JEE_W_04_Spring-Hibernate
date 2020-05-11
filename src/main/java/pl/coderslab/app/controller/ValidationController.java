package pl.coderslab.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/validate")
public class ValidationController {

    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String validateBook(Model model){
//        StringBuffer sb = new StringBuffer();

        Book book = new Book();
        book.setTitle("a");
        book.setRating(101);
        book.setPages(-1000);
        book.setPublisher(new Publisher());

        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);

//        for( ConstraintViolation<Book> bookConstraintViolation : constraintViolations){
//            sb.append(bookConstraintViolation.getPropertyPath());
//            sb.append(" ");
//            sb.append(bookConstraintViolation.getMessage());
//            sb.append("<br>");
//        }
        model.addAttribute("validations", constraintViolations);
        return "book";
    }
    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public String validateAuthor(Model model){

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setPesel("86101074108");
        author.setEmail("emailgmailcom");

        Set<ConstraintViolation<Author>> constraintViolations = validator.validate(author);
        model.addAttribute("validations", constraintViolations);
        return "validation";
    }
    @RequestMapping(value = "/publisher", method = RequestMethod.GET)
    public String validatePublisher(Model model){

        Publisher publisher = new Publisher();
        publisher.setName("John");
        publisher.setNip("12312314142");
        publisher.setRegon("86101074108");

        Set<ConstraintViolation<Publisher>> constraintViolations = validator.validate(publisher);
        model.addAttribute("validations", constraintViolations);
        return "validation";
    }


}