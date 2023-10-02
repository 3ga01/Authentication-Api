package com.example.AuthenticationApi.Service.UserServices;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.AuthenticationApi.Model.Role;
import com.example.AuthenticationApi.Model.User;
import com.example.AuthenticationApi.Repository.RoleRepository;
import com.example.AuthenticationApi.Repository.UserRepository;

@Service
public class UserServiceImplt implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void saveUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        Role role = roleRepository.findByName("ADMIN").get();
        user.setRoles(Collections.singletonList(role));
        userRepository.save(user);
    }

    @Override
    public String findUserByEmail(User user, Authentication authentication) {
        String email = authentication.getName();
        user = userRepository.findByEmail(email);
        return user.getUsername();
    }
}
