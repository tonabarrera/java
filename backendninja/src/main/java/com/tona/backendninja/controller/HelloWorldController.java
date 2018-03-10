package com.tona.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
        model.addAttribute("name", "General Kenobi!");
        return EXAMPLE_VIEW;
    }

    // Segunda forma (cuando se deben insertar muchos datos)
    @RequestMapping(value="/helloModelView", method = RequestMethod.GET)
    public ModelAndView exampleMV() {
        ModelAndView modelAndView = new ModelAndView(EXAMPLE_VIEW);
        modelAndView.addObject("name", "there!");
        return modelAndView;
    }

    // Tercera forma, tambien aplica a ModelAndView
    @GetMapping("/hello")
    public String helloWorld(Model model) {
        model.addAttribute("name", "there!");
        return EXAMPLE_VIEW;
    }
}
