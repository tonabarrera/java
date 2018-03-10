package com.tona.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author tona created on 10/03/2018 for backendninja.
 */
@Controller
@RequestMapping("/anotherExample")
public class AnotherController {
    private static final String ANOTHER_VIEW = "another-example";

    // localhost:8080/anotherExample/request1?nm
    // Por defecto es requerido
    @GetMapping("/request1")
    public ModelAndView request1(@RequestParam(name = "nm", required = false, defaultValue =
            "there!") String name) {
        ModelAndView modelAndView = new ModelAndView(ANOTHER_VIEW);
        modelAndView.addObject("name", name);

        return modelAndView;
    }

    @GetMapping("/request2/{nm}")
    public ModelAndView request2(@PathVariable(value = "nm", required = false) String name) {
        ModelAndView modelAndView = new ModelAndView(ANOTHER_VIEW);
        modelAndView.addObject("name", name);
        return modelAndView;
    }
}
