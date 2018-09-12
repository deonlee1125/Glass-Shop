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
    public String index(Model model, @CookieValue(value="user", defaultValue = "none") String username) {

        model.addAttribute("arts", artDao.findAll());
        model.addAttribute("title", "All Tracked Art");
        return "art/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddArtForm(Model model, @CookieValue(value="user", defaultValue = "none") String username) {

        if(username.equals("none")) {
            return "redirect:/user/login";
        }

        model.addAttribute("title", "Add Art");
        model.addAttribute(new Art());
        model.addAttribute("artistNames", ArtistName.values());
        model.addAttribute("artLocations", ArtLocation.values());
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
    public String displayRemoveArtForm(Model model, @CookieValue(value="user", defaultValue = "none") String username) {

        if(username.equals("none")) {
            return "redirect:/user/login";
        }

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

    @RequestMapping(value = "/edit/{artId}", method = RequestMethod.GET)
    public String displayEditArtForm(Model model, @PathVariable int artId, @CookieValue(value="user", defaultValue = "none") String username) {

        if(username.equals("none")) {
            return "redirect:/user/login";
        }

        Art arts = artDao.findById(artId).get(0);

        model.addAttribute("title", "Edit Art");
        model.addAttribute("art", arts);
        model.addAttribute("artistNames", ArtistName.values());
        model.addAttribute("artLocations", ArtLocation.values());

        return "art/edit";
    }
    @RequestMapping(value="edit", method = RequestMethod.POST)
    public String processEditArtForm(int artId, ArtistName artistName, int trackingNumber, ArtLocation location, String description, Double price, String image){

        Art arts = artDao.findById(artId).get(0);

        arts.setArtistName(artistName);
        arts.setTrackingNumber(trackingNumber);
        arts.setDescription(description);
        arts.setLocation(location);
        arts.setPrice(price);
        arts.setImage(image);

        artDao.save(arts);

        return "redirect:/art";
    }

}

