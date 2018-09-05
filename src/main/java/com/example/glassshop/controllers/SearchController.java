package com.example.glassshop.controllers;

import com.example.glassshop.models.Art;
import com.example.glassshop.models.ArtistName;
import com.example.glassshop.models.data.ArtDao;
import com.example.glassshop.models.forms.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.util.StringUtils;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private ArtDao artDao;
    private Object Art;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String search(Model model) {
        model.addAttribute("artistNames", ArtistName.values());
        model.addAttribute("title", "Search Art");
        model.addAttribute(new SearchForm());
        return "art/search";
    }

    @RequestMapping(value = "results", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute @Valid SearchForm searchForm, Errors errors) {

        Iterable<Art> arts = artDao.findAll();
        List<Art> artSearch = new ArrayList<>();

        for (Art art : arts) {

            if (searchForm.getDescription().isEmpty()) {
                if (searchForm.getArtistName().equals(art.getArtistName())) {
                    artSearch.add(art);
                }
            }
            if (searchForm.getArtistName() == ArtistName.NULL_VALUE) {
                if (art.getDescription().contains(searchForm.getDescription())) {
                    artSearch.add(art);
                }
            }
            if (!searchForm.getDescription().isEmpty() && searchForm.getArtistName() != ArtistName.NULL_VALUE) {
                if (art.getArtistName().equals(searchForm.getArtistName())) {
                    if (art.getDescription().contains(searchForm.getDescription())) {
                        artSearch.add(art);
                    }
                }
            }

            }
            model.addAttribute("title", "Search Results");
            model.addAttribute("artistNames", ArtistName.values());
            model.addAttribute("artSearch", artSearch);

            return "art/search-results";

    }
}

/*}

        if (!StringUtils.isEmptyOrWhitespace(searchForm.getArtistName().name())) {
            artDao.findByArtistName(searchForm.getArtistName().getName());
        }

        if (!StringUtils.isEmptyOrWhitespace(searchForm.getDescription())) {
            artDao.findByDescription(searchForm.getDescription());
        }

        if (!StringUtils.isEmpty(searchForm.getTrackingNumber().toString())) {
            artDao.findByTrackingNumber(searchForm.getTrackingNumber());

           *************
           * if (searchForm.getArtistName() == ArtistName.NULL_VALUE) {
           * ****************
         Iterable<Art> arts = artDao.findAll();
         List<Art> artSearch = new ArrayList<>();

        for (Art art : arts) {

            //if (searchForm.getField().equals(artistName)) {
            if (searchForm.getArtistName().equals(art.getArtistName())) {
                artSearch.add(art);
            }

            if (art.getDescription().contains(searchForm.getDescription())) {
                artSearch.add(art);
            }

            else if (searchForm.getTrackingNumber().equals(art.getTrackingNumber())) {
                artSearch.add(art); */
