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

    @GetMapping("/")
    public String redirectToLogin() {
        LOG.info("redirectToLogin()");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model,
            @RequestParam(name = "error", required = false) String error,
            @RequestParam(name = "logout", required = false) String logout) {
        LOG.info("showLoginForm() -- PARAMS: error" + error + ", logout: " + logout);
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        model.addAttribute("userCredentials", new UserCredential());
        LOG.info("return login view");
        return ViewConstant.LOGIN;
    }

    @PostMapping("/logincheck")
    public String loginCheck(@ModelAttribute(name = "userCredentials") UserCredential userCredential) {
        LOG.info("loginCheck() -- PARAMS: userCredential: " + userCredential.toString());
        if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
            LOG.info("return contacts view");
            return ViewConstant.CONTACTS;
        }
        LOG.info("redirect login error");
        return "redirect:/login?error";
    }
}
