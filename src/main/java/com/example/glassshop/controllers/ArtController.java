package com.example.glassshop.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ArtController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        //model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("title", "Yay!");
        return "index";
    }
}
