package com.shubham.springmvc.restcontroller;

import com.shubham.springmvc.beans.Login;
import com.shubham.springmvc.beans.User;
import com.shubham.springmvc.exceptions.LoginFailureExceptions;
import com.shubham.springmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/hplus/rest/loginuser")
    public ResponseEntity getLoginUser(@RequestBody Login login) throws LoginFailureExceptions {
        System.out.println(login.getUsername() + " "+ login.getPassword());
        User user = userRepository.searchByName(login.getUsername());

        if(null == user){
            return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
        }

        if(user.getUsername().equals(login.getUsername()) &&
            user.getPassword().equals(login.getPassword())){
            return new ResponseEntity<>("Welcome "+user.getUsername(),HttpStatus.OK);
        }
        else {
            // throw new Exception
            throw new LoginFailureExceptions("Invalid username or password");
        }
    }
}
