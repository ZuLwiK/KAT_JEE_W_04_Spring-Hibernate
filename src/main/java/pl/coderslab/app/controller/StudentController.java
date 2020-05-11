package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.entity.Person;
import pl.coderslab.app.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("student", new Student());
        return "studentForm";
    }

    //    @ModelAttribute("hobbies")
//    public List<String> checkOptions() {
//        String[] a = new String[] {"swimming", "hiking", "coding", "books"};
//        return Arrays.asList(a);
//    }
    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }


    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        List<String> programmingSkills = new ArrayList<>();
        programmingSkills.add("Ruby");
        programmingSkills.add("Java");
        programmingSkills.add("Python");
        programmingSkills.add("Scala");
        return programmingSkills;
    }
    @ModelAttribute("hobbies")
    public Collection<String> hobbies() {
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("coding");
        hobbies.add("skiing");
        hobbies.add("swimming");
        hobbies.add("running");
        return hobbies;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public Student createStudent(@ModelAttribute Student student) {

        return student;
    }
//    @RequestMapping(value = "/new", method = RequestMethod.POST)
//    @ResponseBody
//    public String createStudent(@RequestParam String firstName,
//                                @RequestParam String lastName, Model model) {
//        Student student = new Student(firstName, lastName);
//        model.addAttribute("student", student);
//        return "form/success";
//    }
}
