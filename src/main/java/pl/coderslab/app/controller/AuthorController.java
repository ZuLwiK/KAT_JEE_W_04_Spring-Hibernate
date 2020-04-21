package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.entity.Author;

@Controller
public class AuthorController {
    private final AuthorDao authorDAO;

    public AuthorController(AuthorDao authorDAO) {
        this.authorDAO = authorDAO;
    }
    @RequestMapping("/author/add")
    @ResponseBody
    public String saveAuthor() {
        Author author = new Author();
        author.setFirstName("Bruce");
        author.setLastName("Ekhel");
        authorDAO.saveAuthor(author);
        return "Id dodanego autora to:"
                + author.getId();
    }
    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = authorDAO.findById(id);
        return author.toString();
    }
    @RequestMapping("/author/update/{id}/{firstName}/{lastName}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id, @PathVariable String firstName, @PathVariable String lastName){
        Author author=authorDAO.findById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        return author.toString();
    }
    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id) {
        Author author = authorDAO.findById(id);
        authorDAO.delete(author);
        return "deleted";
    }
}
