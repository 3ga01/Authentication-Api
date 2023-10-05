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

    @GetMapping("/user/home")
    public ModelAndView getHome() {
        return new ModelAndView("/pages/user/home");
    };

    @GetMapping("/user/dashboard/statement")
    public ModelAndView getStatement() {
        return new ModelAndView("/pages/user/statement");
    };

    @GetMapping("/user/dashboard/userInfo")
    public ModelAndView getUserInfo() {
        return new ModelAndView("/pages/user/userInfo");
    };

    @GetMapping("/user/dashboard/calender")
    public ModelAndView getCalender() {
        return new ModelAndView("/pages/user/calender");
    };

    @GetMapping("/user/dashboard/annoucements")
    public ModelAndView getAnnoucements() {
        return new ModelAndView("/pages/user/annoucements");
    };

    @GetMapping("/user/dashboard/upComingEvents")
    public ModelAndView getUpComingEvents() {
        return new ModelAndView("/pages/user/upComingEvents");
    };

    @GetMapping("/user/dashboard/clubs")
    public ModelAndView getClubs() {
        return new ModelAndView("/pages/user/clubs");
    };

    @GetMapping("/user/dashboard/fees")
    public ModelAndView getFees() {
        return new ModelAndView("/pages/user/fees");
    };

    @GetMapping("/user/dashboard/assignments")
    public ModelAndView getAssignments() {
        return new ModelAndView("/pages/user/assignments");
    };

    @GetMapping("/user/dashboard/exams")
    public ModelAndView getExam() {
        return new ModelAndView("/pages/user/exams");
    };

    @GetMapping("/user/dashboard/learningMaterials")
    public ModelAndView getLearningMaterials() {
        return new ModelAndView("/pages/user/learningMaterials");
    };

    @GetMapping("/user/dashboard/pastQuestions")
    public ModelAndView getPastQuestions() {
        return new ModelAndView("/pages/user/pastQuestions");
    };

    @GetMapping("/user/dashboard/libraryServices")
    public ModelAndView getLibraryServices() {
        return new ModelAndView("/pages/user/libraryServices");
    };

}
