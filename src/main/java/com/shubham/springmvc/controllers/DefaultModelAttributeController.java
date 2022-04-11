package com.shubham.springmvc.controllers;

import com.shubham.springmvc.beans.Login;
import com.shubham.springmvc.beans.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class DefaultModelAttributeController {

    @ModelAttribute("newUser")
    public User getDefaultUser() {
        return new User();
    }

    @ModelAttribute("genderItems")
    public List<String> getGenderItems() {
        return Arrays.asList("Male", "Female", "Other");
    }

    @ModelAttribute("login")
    public Login getDefaultLogin(){
        return new Login();
    }
}
