package com.example.AuthenticationApi.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.AuthenticationApi.Model.User;
import com.example.AuthenticationApi.Repository.UserRepository;

@Service
public class UserDetails implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }



        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), null);
    }

}
