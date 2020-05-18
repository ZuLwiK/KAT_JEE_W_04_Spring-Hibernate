package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final AuthorDao authorDAO;

    public AuthorController(AuthorDao authorDAO) {
        this.authorDAO = authorDAO;
    }

//  Wyświetlanie wszystkich autorów
    @GetMapping(value = "/all")
    public String getAll(Model model) {
        List<Author> authors = authorDAO.findAllAuthors();
        model.addAttribute("authors",authors);
        return "authors";
    }
//  Dodawanie nowego autora po odpowiedniej walidacji
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("author", new Author());
        return "authorForm";
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String create(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "authorForm";
        }
        authorDAO.saveAuthor(author);
        return "redirect:/author/all";
    }
//  Edytowanie autora, z powtórzeniem walidacji
    @RequestMapping(value="/edit/{id}", method= RequestMethod.GET)
    public String editForm(Model model,@PathVariable long id) {
        model.addAttribute("author",authorDAO.findAuthorById(id));
        return "authorForm";
    }
    @RequestMapping(value="/edit/{id}", method= RequestMethod.POST)
    public String edit(@Valid Author author,BindingResult result){
        if (result.hasErrors()){
            return "authorForm";
        }
        authorDAO.updateAuthor(author);
        return "redirect:/author/all";
    }
//  Usuwanie autora
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@Valid Author author,BindingResult result){
        if(result.hasErrors()){
            return "/all";
        }
        authorDAO.deleteAuthor(author);
        return "redirect:/author/all";
    }

}
