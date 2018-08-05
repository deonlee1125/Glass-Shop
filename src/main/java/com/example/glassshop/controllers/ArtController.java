package com.example.glassshop.controllers;

import com.example.glassshop.models.forms.Art;
import com.example.glassshop.models.forms.ArtData;
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

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("arts", ArtData.getAll());
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
    public String processAddArtForm(@ModelAttribute Art newArt) {
        ArtData.add(newArt);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveArtForm(Model model) {
        model.addAttribute("arts", ArtData.getAll());
        model.addAttribute("title", "Remove Art");
        return "art/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveArtForm(@RequestParam int[] artIds) {

        for (int artId : artIds) {
            ArtData.remove(artId);
        }

        return "redirect:";
    }
}
