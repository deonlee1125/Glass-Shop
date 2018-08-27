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
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Registration");
        User user = new User();
        //user.setUsername("noob");
        model.addAttribute("user", user);

        return "home/register";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, VerifyError verify) {
        List<User> sameName = userDao.findByUsername(user.getUsername());
        if(!errors.hasErrors() && user.getPassword().equals(verify) && sameName.isEmpty()) {
            model.addAttribute("user", user);
            userDao.save(user);
            return "home/register";
        } else {
            model.addAttribute("user", user);
            model.addAttribute("title", "User Login");
            if(!user.getPassword().equals(verify)) {
                model.addAttribute("message", "Passwords must match.");
                user.setPassword("");
            }
            if(!sameName.isEmpty()) {
                model.addAttribute("message", "Username is taken. Please provide another.");
            }
            }

        return "redirect:/";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "home/login";
    }

    /*@RequestMapping(value = {"logout"}, method = RequestMethod.GET)
    public String logout(HttpServletRequest request Model model) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                c.setMaxAge(0);
                c.setPath("/");
                response.addCookie(c);
            }
        }
            return "home/login";
        }
    */
}