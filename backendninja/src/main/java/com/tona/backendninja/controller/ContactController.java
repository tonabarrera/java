package com.tona.backendninja.controller;

import com.tona.backendninja.constant.ViewConstant;
import com.tona.backendninja.model.ContactModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tona created on 16/03/2018 for backendninja.
 */
@Controller
@RequestMapping("/contact")
public class ContactController {
    private static final Log LOG = LogFactory.getLog(ContactController.class);

    @GetMapping("/cancel")
    public String cancel() {
        return ViewConstant.CONTACTS;
    }

    @GetMapping("/form")
    public String redirectContactForm(Model model) {
        model.addAttribute("contactModel", new ContactModel());
        return ViewConstant.CONTACT_FORM;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(name = "contactModel") ContactModel contactModel,
            Model model) {
        model.addAttribute("result", 1);
        LOG.info("add() -- PARAMS: " + contactModel.toString());
        return ViewConstant.CONTACTS;
    }
}
