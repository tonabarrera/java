package com.tona.login.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private static final Log LOG = LogFactory.getLog(LoginController.class);

    @GetMapping("/login")
    public String login(Model model, @RequestParam(name = "error", required = false) String error,
                        @RequestParam(name = "logout", required = false) String logout) {
        LOG.info("showLoginForm() -- PARAMS: error: " + error + ", logout: " + logout);

        model.addAttribute("error", error);
        model.addAttribute("logout", logout);

        return "login";
    }

    @GetMapping("/loginsuccess")
    public String loginSuccess(Model model) {
        LOG.info("loginSuccess()");
        return "home-dch";
    }
}
