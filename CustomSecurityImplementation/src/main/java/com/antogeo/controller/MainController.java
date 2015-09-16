package com.antogeo.controller;


import com.antogeo.dto.UserDTO;
import com.antogeo.form.LoginForm;
import com.antogeo.service.UserService;
import com.antogeo.util.enums.RoleConstant;
import com.antogeo.validator.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class MainController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin(HttpSession session, Model model){
        if (session.getAttribute("user") != null) {
            return "dashboard";
        }
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@Valid @ModelAttribute(value = "loginForm") LoginForm form, BindingResult result, HttpSession session, Model model){

        //Check user authentication
        if (session.getAttribute("user") != null) {
            return "dashboard";
        }

        //Call Validator method
        LoginValidator validator = new LoginValidator();
        validator.validate(form, result);
        if(result.hasErrors()){

            return "login";
        }

        //Authenticate user
        UserDTO userDTO = userService.authenticateUser(form.getUsername(), form.getPassword());

        if (!userDTO.getExist() || !userDTO.getIsAuthenticated()){
            model.addAttribute("message","Username or password wrong");
            return "login";
        }else{
            model.addAttribute("message","Congratulations");
            session.setAttribute("user", userDTO);
            return "dashboard";
        }
    }


    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(HttpSession session, Model model){

        //Check user authentication
        if (session.getAttribute("user") == null) {
            model.addAttribute("loginForm", new LoginForm());
            return "login";
        }
        return "dashboard";
    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(HttpSession  session, Model model){

        //Check user authentication
        if (session.getAttribute("user") == null) {
            model.addAttribute("loginForm", new LoginForm());
            return "login";
        }

        //Check  user authorization
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        String role = userDTO.getUser().getRole().getName();
        Boolean authorized = false;
        if(role.equals(RoleConstant.ADMIN)){
            authorized = true;
        }
        if(!authorized){
            model.addAttribute("message","You are not authorized");
            return "dashboard";
        }

        return "admin";
    }



    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession  session, Model model){
        session.invalidate();
        model.addAttribute("message", "Your session was terminated!");
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }


}
