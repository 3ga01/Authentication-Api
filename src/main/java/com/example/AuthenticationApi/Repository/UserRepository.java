package com.example.AuthenticationApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AuthenticationApi.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);

}
