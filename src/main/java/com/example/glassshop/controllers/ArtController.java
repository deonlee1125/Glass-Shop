package com.example.glassshop.controllers;

import com.example.glassshop.models.forms.Art;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("art")
public class ArtController {

    static ArrayList<Art> arts = new ArrayList<>();
    //static HashMap<String, String> arts = new HashMap<>();

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("arts", arts);
        model.addAttribute("title", "Welcome to ARTracker!");
        return "art/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddArtForm(Model model) {
        model.addAttribute("title", "Add Art");
        //model.addAttribute(new Art());
        //model.addAttribute("categories", categoryDao.findAll());
        return "art/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddArtForm(@RequestParam Integer artistNumber, @RequestParam String artistName,
                                    @RequestParam Integer trackingNumber,
                                    @RequestParam String description, @RequestParam String location,
                                    @RequestParam Double price) {
        Art newArt = new Art(artistNumber, artistName, trackingNumber, description, location, price);
        arts.add(newArt);
        return "redirect:";
    }
}
