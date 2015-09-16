package com.antogeo.controller;

import com.antogeo.form.LoginForm;
import com.antogeo.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/create-object", method = RequestMethod.POST)
    public String createObject(Object object) {

        objectService.insert(object);


        return "object";

    }

    @RequestMapping(value = "/edit-object", method = RequestMethod.POST)
    public String editObject(@RequestParam("objectId") int objectId, @RequestParam("value") int value){

        //int id = Integer.valueOf(objectId);

       // objectService.

        //objectService.update(id);

        return "object";
    }

    @RequestMapping(value = "/delete-object", method = RequestMethod.POST)
    public String deleteObject(@RequestParam("objectId") String objectId){

        int id = Integer.valueOf(objectId);
        objectService.update(id);

        return "object";
    }

}