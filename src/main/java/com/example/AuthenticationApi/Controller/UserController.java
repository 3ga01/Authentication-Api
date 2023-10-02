package com.example.AuthenticationApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.AuthenticationApi.Model.User;
import com.example.AuthenticationApi.Repository.UserRepository;
import com.example.AuthenticationApi.Service.UserServices.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/welcome")
    public ModelAndView getWelcomePage(Authentication authentication, Model model, User user) {

        String authenticatedUser = userService.findUserByEmail(user, authentication);

        model.addAttribute("authenticatedUser", authenticatedUser);
        return new ModelAndView("pages/user/userWelcome");
    }

}
