package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dao.BookDao;
import pl.coderslab.app.dao.PublisherDao;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;
import pl.coderslab.app.validation.PropositionsGroup;
import pl.coderslab.app.validation.PublishersGroup;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

//    Wyświetlanie wszystkich wydawców
    @RequestMapping(value = "/all")
    public String getAll(Model model) {
        List<Publisher> publishers = publisherDao.findAllPublishers();
        model.addAttribute("publishers", publishers);
        return "publishers";
    }
//  Edytowanie wydawce, z powtórzeniem walidacji
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editForm(Model model, @PathVariable long id) {
        model.addAttribute("publisher", publisherDao.findPublisherById(id));
        return "publisherForm";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@Validated({
            PublishersGroup.class}) @ModelAttribute("publisher") @Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "/all";
        }
        publisherDao.updatePublisher(publisher);
        return "redirect:/publisher/all";
    }
//    Usuwanie publishera
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@Validated({
            PublishersGroup.class}) @Valid Publisher publisher,BindingResult result){
        if (result.hasErrors()) {
            return "/all";
        }
        publisherDao.deletePublisher(publisher);
        return "redirect:publisher/all";
    }
}
