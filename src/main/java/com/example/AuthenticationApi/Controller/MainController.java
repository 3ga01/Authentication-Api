package com.example.AuthenticationApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.AuthenticationApi.Model.User;
import com.example.AuthenticationApi.Repository.UserRepository;

@RestController
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public ModelAndView getHomePage() {

        return new ModelAndView("index");
    }

    @GetMapping("/signUp")
    public ModelAndView getSignUpPage() {

        return new ModelAndView("signUp");
    }

    @GetMapping("/signUpEmail")
    public ModelAndView getSignUpEmailPage(Model model) {
        model.addAttribute("user", new User());
        return new ModelAndView("signUpEmail");
    }

    @GetMapping("/welcome")
    public ModelAndView getWelcomePage() {
        return new ModelAndView("welcome");
    }

    @PostMapping("/signUp")
    public ModelAndView addNewUser(@ModelAttribute("user") User user) {

        userRepository.save(user);
        System.out.println(user.getEmail());

        return new ModelAndView("redirect:/welcome");
    }
}
