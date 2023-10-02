package com.example.AuthenticationApi.Service.UserServices;

import org.springframework.security.core.Authentication;

import com.example.AuthenticationApi.Model.User;

public interface UserService {

    void saveUser(User user);

    String findUserByEmail( User user, Authentication authentication);

}
