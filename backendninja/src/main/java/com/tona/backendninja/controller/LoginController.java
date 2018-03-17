package com.tona.backendninja.controller;

import com.tona.backendninja.constant.ViewConstant;
import com.tona.backendninja.model.UserCredential;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author tona created on 14/03/2018 for backendninja.
**/
@Controller
public class LoginController {

    private static final Log LOG = LogFactory.getLog(LoginController.class);

    @GetMapping("/login")
    public String showLoginForm(Model model,
            @RequestParam(name = "error", required = false) String error,
            @RequestParam(name = "logout", required = false) String logout) {
        LOG.info("showLoginForm() -- PARAMS: error" + error + ", logout: " + logout);
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        LOG.info("return login view");
        return ViewConstant.LOGIN;
    }

    @GetMapping({"/loginsuccess", "/"})
    public String loginSuccess() {
        LOG.info("METHOD: loginSucess()");
        return "redirect:/contact/show";
    }
}
