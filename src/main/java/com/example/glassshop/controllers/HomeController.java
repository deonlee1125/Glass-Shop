package com.example.glassshop.controllers;

//import com.example.glassshop.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class HomeController {
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Welcome to ARTracker!");
        return "home/index";
    }
/*
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String displayLoginForm (Model model) {
        model.addAttribute("title", "Log in to ARTracker");
        return "home/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processLoginForm (Model model, @ModelAttribute @Valid User newUser, Errors errors) {
        if (errors.hasErrors())
            model.addAttribute("title", "Log in to ARTracker");
        return "home/login";
    } */
}
