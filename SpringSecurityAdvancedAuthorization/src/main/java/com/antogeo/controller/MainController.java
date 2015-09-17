package com.antogeo.controller;

import com.antogeo.entity.Object;
import com.antogeo.form.LoginForm;
import com.antogeo.form.ObjectForm;
import com.antogeo.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ObjectService objectService;

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

    @RequestMapping(value = "/object", method = RequestMethod.GET)
    public String viewObject(Model model) {

        List<Object> objects = objectService.getAll();

        model.addAttribute("objectForm", new ObjectForm());
        model.addAttribute("objects", objects);

        return "object";
    }

    @RequestMapping(value = "/create-object", method = RequestMethod.POST)
    public String createObject(@Valid @ModelAttribute(value = "objectForm")ObjectForm objectForm, Principal principal, BindingResult result) {

        objectService.insertObject(objectForm, principal);

        return "redirect:/object";
    }

}