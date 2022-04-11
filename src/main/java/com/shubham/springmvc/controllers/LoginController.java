package com.shubham.springmvc.controllers;

import com.shubham.springmvc.beans.Login;
import com.shubham.springmvc.beans.User;
import com.shubham.springmvc.exceptions.ApplicationException;
import com.shubham.springmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@ModelAttribute("login")Login login, HttpSession session){
        // full session management
        // with session object
        // session.setAttribute(...);
        System.out.println("in login controller");
        User user = userRepository.searchByName(login.getUsername());
        if(user == null){
            throw new ApplicationException("User not Found!");
        }
        return "forward:/userprofile";
    }

    @ExceptionHandler(ApplicationException.class)
    public String handleException(){
        System.out.println("in exception handler of login Controller");
        return "error";
    }

}
