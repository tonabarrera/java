package com.tona.backendninja.controller;

import com.tona.backendninja.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tona created on 09/03/2018 for backendninja.
 */
@Controller
@RequestMapping("/say")
public class HelloWorldController {
    private static final String EXAMPLE_VIEW = "example";

    // Primera forma (para redirecciones)
    @RequestMapping(value="/helloString", method = RequestMethod.GET)
    public String exampleString(Model model) {
        model.addAttribute("people", getPeople());
        return EXAMPLE_VIEW;
    }

    // Segunda forma (cuando se deben insertar muchos datos)
    @RequestMapping(value="/helloModelView", method = RequestMethod.GET)
    public ModelAndView exampleMV() {
        ModelAndView modelAndView = new ModelAndView(EXAMPLE_VIEW);
        modelAndView.addObject("people", getPeople());
        return modelAndView;
    }

    // Tercera forma, tambien aplica a ModelAndView
    @GetMapping("/hello")
    public String helloWorld(Model model) {
        model.addAttribute("people", getPeople());
        return EXAMPLE_VIEW;
    }

    private List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("General Kenobi",30));
        people.add(new Person("Griveous",10));
        people.add(new Person("Anakin",20));
        people.add(new Person("Palpatine",80));
        people.add(new Person("R2D2",2));

        return people;
    }
}
