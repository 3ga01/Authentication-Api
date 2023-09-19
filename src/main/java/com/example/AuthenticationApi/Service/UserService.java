package com.example.AuthenticationApi.Service;


import org.springframework.stereotype.Service;

import com.example.AuthenticationApi.Model.User;

@Service
public interface UserService {

    void save(User user);
}
