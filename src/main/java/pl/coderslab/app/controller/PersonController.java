package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.dao.PersonDao;
import pl.coderslab.app.dao.PersonDetailsDao;
import pl.coderslab.app.entity.Person;
import pl.coderslab.app.entity.PersonDetails;

@Controller
public class PersonController {
    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }
    @RequestMapping("/person/add")
    @ResponseBody
    public String savePerson() {
        Person person = new Person();
        person.setLogin("login1");
        person.setPassword("password1");
        person.setEmail("email1");
        personDao.save(person);
        return "Id dodanej osoby to:"
                + person.getId();
    }

    @RequestMapping("/person/get/{id}")
    @ResponseBody
    public String getPerson(@PathVariable long id) {
        Person person = personDao.findById(id);
        return person.toString();
    }
    @RequestMapping("/person/update/{id}/{login}/{password}/{email}/{password}")
    @ResponseBody
    public Person updatePerson(@PathVariable long id, @PathVariable String login, @PathVariable String password, @PathVariable String email){
        Person person=personDao.findById(id);
        person.setLogin(login);
        person.setEmail(email);
        person.setPassword(password);
        return person;
    }
    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deletePerson(@PathVariable long id) {
        Person person = personDao.findById(id);
        personDao.delete(person);
        return "deleted";
    }
    @GetMapping("/person/addAll")
    @ResponseBody
    public Person savePersonAll() {
        Person person = new Person();
        person.setLogin("login1");
        person.setPassword("password1");
        person.setEmail("email1");
        personDao.save(person);

        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("name");
        personDetails.setLastName("lastName");
        personDetails.setStreet("street");
        personDetails.setStreetNumber(15);
        personDetails.setCity("City");
        personDetailsDao.save(personDetails);
        person.setDetails(personDetails);
        return person;
    }
}
