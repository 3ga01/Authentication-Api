package com.example.AuthenticationApi.Service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
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
    RoleService roleService;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void saveUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        Role roles = roleRepository.findByName("ADMIN").get();
        user.setRoles(Collections.singletonList(roles));
        userRepository.save(user);
    }

}
