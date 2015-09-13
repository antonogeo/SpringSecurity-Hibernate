package com.antogeo.web.controller;

import com.antogeo.web.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @RequestMapping(value = { "/", "/login" }, method = {RequestMethod.GET, RequestMethod.POST})
      public String login(@RequestParam(value = "error", required = false) String error,
                          @RequestParam(value = "logout", required = false) String logout,
                          Model model) {

        if (error != null) {
            model.addAttribute("error","Invalid username or password!" );
        }

        if (logout != null) {
            model.addAttribute("msg","You've been logged out successfully." );
        }

        model.addAttribute("loginForm", new LoginForm());

        return "login";
    }


    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model){

        return "dashboard";
    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model){

        return "admin";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model) {

        return "403";

    }

}