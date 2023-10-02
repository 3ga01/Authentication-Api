package com.example.AuthenticationApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.AuthenticationApi.Model.User;
import com.example.AuthenticationApi.Repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/welcome")
    public ModelAndView getWelcomePage(Authentication authentication, Model model) {
        String authenticatedUser = authentication.getName();
        userRepository.findByEmail(authenticatedUser);
        User search = userRepository.findByEmail(authenticatedUser);
        authenticatedUser = search.getUsername();

        model.addAttribute("authenticatedUser", authenticatedUser);
        return new ModelAndView("pages/user/userWelcome");
    }

}
