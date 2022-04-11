package com.shubham.springmvc.controllers;

import com.shubham.springmvc.beans.User;
import com.shubham.springmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(Date.class, "dateOfBirth",
                new CustomDateEditor(new SimpleDateFormat("yyy-MM-dd"), true));
    }

    @PostMapping("/registeruser")
    public String registerUser(@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model){
        System.out.println("in registration controller");
//        System.out.println(user.getDateOfBirth());
        if(result.hasErrors()){
            return "register";
        }

        userRepository.save(user);
        model.addAttribute("dataSaved", "User Registered Successfully");
        return "login";
    }

}
