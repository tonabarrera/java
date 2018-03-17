package com.tona.backendninja.controller;

import com.tona.backendninja.constant.ViewConstant;
import com.tona.backendninja.model.ContactModel;
import com.tona.backendninja.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author tona created on 16/03/2018 for backendninja.
 */
@Controller
@RequestMapping("/contact")
public class ContactController {
    private static final Log LOG = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("contactServiceImpl")
    private ContactService contactService;

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/contact/show";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/form")
    public String redirectContactForm(@RequestParam(name = "id") int id,
            Model model) {
        ContactModel contactModel = new ContactModel();
        if (id != 0)
            contactModel = contactService.findContactModelById(id);

        model.addAttribute("contactModel", contactModel);
        return ViewConstant.CONTACT_FORM;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(name = "contactModel") ContactModel contactModel,
            Model model) {
        LOG.info("add() -- PARAMS: " + contactModel.toString());

        if(contactService.add(contactModel) != null)
            model.addAttribute("result", 1);
        else
            model.addAttribute("result", 0);
        return "redirect:/contact/show";

    }

    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView(ViewConstant.CONTACTS);
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        modelAndView.addObject("username", user.getUsername());
        modelAndView.addObject("contacts", contactService.listAllContacts());
        return modelAndView;
    }

    @GetMapping("/remove")
    public ModelAndView remove(@RequestParam(name = "id") int id) {
        contactService.removeContact(id);
        return show();
    }
}
