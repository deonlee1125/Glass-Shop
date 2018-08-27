package com.example.glassshop.controllers;

import com.example.glassshop.models.data.ArtDao;
import com.example.glassshop.models.Art;
import com.example.glassshop.models.ArtLocation;
import com.example.glassshop.models.ArtistName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("art")
public class ArtController {

    @Autowired
    private ArtDao artDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("arts", artDao.findAll());
        model.addAttribute("title", "All Tracked Art");
        return "art/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddArtForm(Model model) {
        model.addAttribute("title", "Add Art");
        model.addAttribute(new Art());
        model.addAttribute("artistNames", ArtistName.values());
        model.addAttribute("artLocations", ArtLocation.values());
        //model.addAttribute("categories", categoryDao.findAll());
        return "art/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddArtForm(@ModelAttribute @Valid Art newArt,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Art");
            model.addAttribute("artistNames", ArtistName.values());
            model.addAttribute("artLocations", ArtLocation.values());
            return "art/add";
        }

        artDao.save(newArt);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveArtForm(Model model) {
        model.addAttribute("arts", artDao.findAll());
        model.addAttribute("title", "Remove Art");
        return "art/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveArtForm(@RequestParam int[] artIds) {

        for (int artId : artIds) {
            artDao.delete(artId);
        }
        return "redirect:";
    }
/*
    @RequestMapping(value = "edit/{artId}", method = RequestMethod.GET)
    public String displayEditArtForm(Model model, @PathVariable int artId){
        artDao.findOne(artId);
        model.addAttribute("artistNames", ArtistName.values());
        model.addAttribute("artLocations", ArtLocation.values());
        return "art/edit";

    @RequestMapping(value="edit", method = RequestMethod.POST)
    public String processEditArtForm(Model model, int artId){

    }*/
}

