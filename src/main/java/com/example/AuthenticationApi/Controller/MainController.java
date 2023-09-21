package com.example.AuthenticationApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.AuthenticationApi.Model.User;
import com.example.AuthenticationApi.Service.UserService;

@RestController
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView getHomePage() {

        return new ModelAndView("index");
    }

    @GetMapping("/signUp")
    public ModelAndView getSignUpPage() {

        return new ModelAndView("signUp");
    }

    @GetMapping("/signUpEmail")
    public ModelAndView getSignUpEmailPage() {
        return new ModelAndView("signUpEmail");
    }

    @GetMapping("/welcome")
    public ModelAndView getWelcomePage() {
        return new ModelAndView("welcome");
    }

    @PostMapping("/signUp")
    public ModelAndView addNewUser(@ModelAttribute("user") User user) {

        userService.save(user);

        return new ModelAndView("index");
    }
}
