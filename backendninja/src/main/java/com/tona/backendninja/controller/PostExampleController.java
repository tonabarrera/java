package com.tona.backendninja.controller;

import com.tona.backendninja.model.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author tona created on 10/03/2018 for backendninja.
 */
@Controller
@RequestMapping("/postExample")
public class PostExampleController {
    private static final Log LOGGER = LogFactory.getLog(PostExampleController.class);


    private static final String FORM_VIEW = "form";
    private static final String RESULT_VIEW = "result-view";

    // Forma uno
    @GetMapping("/")
    public String redirect() {
        return "redirect:/postExample/form";
    }

    @GetMapping("")
    public RedirectView redirectView() {
        return new RedirectView("/postExample/form");
    }

    @GetMapping("/form")
    public String getFormViewform(Model model) {
        model.addAttribute("person", new Person());
        LOGGER.info("INFO TRACE");
        LOGGER.warn("WARNING TRACE");
        LOGGER.debug("DEBUG TRACE");
        LOGGER.error("ERROR TRACE");
        LOGGER.fatal("FATAL TRACE");
        return FORM_VIEW;
    }

    @PostMapping("/addPerson")
    public ModelAndView addPerson(@ModelAttribute("person") Person person) {
        ModelAndView modelAndView = new ModelAndView(RESULT_VIEW);
        modelAndView.addObject("person", person);
        return modelAndView;
    }
}
