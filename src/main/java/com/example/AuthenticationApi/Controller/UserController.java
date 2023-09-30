package com.example.AuthenticationApi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @GetMapping("/user/welcome")
    public ModelAndView getWelcomePage() {
        return new ModelAndView("userWelcome");
    }

}
