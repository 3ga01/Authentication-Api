package com.example.AuthenticationApi.Service;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.AuthenticationApi.Model.User;
import com.example.AuthenticationApi.Repository.UserRepository;

@Service
public class UserDetailsSvc implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + email);
        }

        // Create a UserDetails object with the user's details
        // You may need to adjust this based on your User entity's structure
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),

                // Add user roles here
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
