package com.example.glassshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("art")
public class ArtController {

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Welcome to ARTracker!");
        return "art/index";
    }
}

     /*@RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {

        //model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "Welcome to ARTracker!");

        return "art/index";
    }
}
   @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("categories", categoryDao.findAll());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese,
                                       Errors errors, @RequestParam int categoryId, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute( "categories", categoryDao.findAll());
            return "cheese/add";
        }

        Category cat = categoryDao.findOne(categoryId);
        newCheese.setCategory(cat);
        cheeseDao.save(newCheese);
        return "redirect:";
    }*/
