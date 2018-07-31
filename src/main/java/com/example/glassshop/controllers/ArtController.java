package com.example.glassshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("art")
public class ArtController {

    static ArrayList<String> arts = new ArrayList<>();

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("arts", arts);
        model.addAttribute("title", "Welcome to ARTracker!");
        return "art/index";
    }


    /*@RequestMapping(value = "", method = RequestMethod.GET)
   public String index(Model model) {

       //model.addAttribute("cheeses", cheeseDao.findAll());
       model.addAttribute("title", "Welcome to ARTracker!");

       return "art/index";
   }
}*/
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddArtForm(Model model) {
        model.addAttribute("title", "Add Art");
        //model.addAttribute(new Art());
        //model.addAttribute("categories", categoryDao.findAll());
        return "art/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddArtForm(@RequestParam String artType) {
        arts.add(artType);
        return "redirect:";
    }
}


    /*public String processAddArtForm(@ModelAttribute @Valid Cheese newCheese,
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
