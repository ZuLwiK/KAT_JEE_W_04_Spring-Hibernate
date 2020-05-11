package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import pl.coderslab.app.dao.BookDao;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.validation.PropositionsGroup;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/proposition")
public class PropositionController {


    private final BookDao bookDao;

    public PropositionController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping(value = "/all")
    public String getAll(Model model) {
        List<Book> propositions = bookDao.findAllBookPropostitions();
        model.addAttribute("propositions", propositions);
        return "propositions";
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("proposition", new Book());
        return "propositionForm";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String create(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "propositionForm";
        }
        bookDao.saveBook(book);
        return ("redirect:/proposition/all");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editForm(Model model, @PathVariable long id) {
        model.addAttribute("proposition", bookDao.findBookById(id));
        return "propositionForm";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@Validated({
        PropositionsGroup.class}) @ModelAttribute("proposition") @Valid Book proposition,BindingResult result){
        if (result.hasErrors()) {
            return "proposition/all";
        }
        bookDao.updateBook(proposition);
        return ("redirect:/proposition/all");
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@Validated({
            PropositionsGroup.class}) @ModelAttribute("proposition") @Valid Book proposition,BindingResult result){
        if (result.hasErrors()) {
            return "proposition/all";
        }
        bookDao.deleteBook(proposition);
        return ("redirect:/proposition/all");
    }
}
