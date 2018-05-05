package com.tona.login.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/dch")
public class DchController {
    private static final Log LOG = LogFactory.getLog(DchController.class);

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        LOG.info("DchController.home() principal = " + principal.getName());

        return "home-dch";
    }
}
