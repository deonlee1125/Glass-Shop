/*package com.example.glassshop.models.validator;

import com.example.glassshop.models.User;
import com.example.glassshop.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserValidator userValidator;

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 15) {
            errors.rejectValue("username", "Username must be between 5 and 15 characters long.");
        }
        if (userDao.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Username taken. please select another.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 15) {
            errors.rejectValue("password", "Password must be between 8 and 15 characters long.");
        }

        if (!user.getPasswordVerify().equals(user.getPassword())) {
            errors.rejectValue("passwordVerify", "Passwords must match");
        }
    }
}*/