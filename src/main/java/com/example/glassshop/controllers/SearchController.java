package com.example.glassshop.controllers;

import com.example.glassshop.models.Art;
import com.example.glassshop.models.ArtistName;
import com.example.glassshop.models.SearchFieldType;
import com.example.glassshop.models.data.ArtDao;
import com.example.glassshop.models.forms.SearchArtForm;
import com.example.glassshop.models.forms.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.internal.util.collections.CollectionHelper.arrayList;


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
        model.addAttribute(new SearchArtForm());
        return "art/search";
    }

    @RequestMapping(value = "results", method = RequestMethod.POST)
    public String search(Model model, @ModelAttribute @Valid SearchArtForm searchArtForm, Errors errors) {

        Iterable<Art> art = artDao.findAll();
        List<Art> artSearch = new ArrayList<>();


        for(Art a : art){
            if(searchArtForm.getArtistName().equals(a.getArtistName())){
                artSearch.add(a);
            }
        }

        model.addAttribute("artistNames", ArtistName.values());
        model.addAttribute("artSearch", artSearch);

//        model.addAttribute(searchForm);

//        if (searchForm.getSearchField().equals("Description")) {
//            List art = artDao.findByDescription(searchForm.getKeyword());
//            model.addAttribute("art", art);
//
//        }

        return "art/search";
    }

}

/*
        if (searchForm.getSearchField().equals(JobFieldType.ALL)) {
                jobs = jobData.findByValue(searchForm.getKeyword());
                } else {
                jobs = jobData.findByColumnAndValue(searchForm.getSearchField(), searchForm.getKeyword());
                }

                model.addAttribute("jobs", jobs);
                */