package com.example.glassshop.controllers;

import com.example.glassshop.models.User;
import com.example.glassshop.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Registration");
        User user = new User();
        model.addAttribute("user", user);

        return "user/register";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors) {

        List<User> sameName = userDao.findByUsername(user.getUsername());

        if (!errors.hasErrors() && sameName.isEmpty() && user.getPassword().equals(user.getPasswordVerify())) {
            model.addAttribute("user", user);
            userDao.save(user);
            return "user/index";

        } else {
            model.addAttribute("title", "Please Try Again");
            return "user/register";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String displayLoginForm(Model model, String logout) {

        model.addAttribute("title", "Login Page");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        model.addAttribute("title", "Login Page");
        model.addAttribute(new User());
        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processLoginForm(Model model, @ModelAttribute User user, HttpServletResponse response) {

        List<User> u = userDao.findByUsername(user.getUsername());

        if (u.isEmpty()) {
            model.addAttribute("message", "Username already exists. Please choose another.");
            model.addAttribute("title", "Unsuccessful Login");
            return "user/login";
        }

        User loggedIn = u.get(0);
        if (loggedIn.getPassword().equals(user.getPassword())) {

            Cookie c = new Cookie("user", user.getUsername());
            c.setPath("/");
            response.addCookie(c);
            model.addAttribute("title", "Welcome to ARTracker!");
            return "user/index";

        } else {
            model.addAttribute("title", "Unsuccessful Login");
            model.addAttribute("message", "Invalid Password");
            return "user/login";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                c.setMaxAge(0);
                c.setPath("/");
                response.addCookie(c);
            }
        }

            return "user/logout";
        }
    }