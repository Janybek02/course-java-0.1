package com.example.course.controllers;

import com.example.course.personDAO.PersonDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/people")
public class PeopleControllers {

    private final PersonDAO personDAO;
    public PeopleControllers(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    @GetMapping("")
    public String getIndex(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.show(id));
       return "people/show";
    }
}
