package com.example.AuthenticationApi.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AuthenticationApi.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    // Optional<Role> findByName(String role1, String role2);
    Optional<Role> findByName(String role);
}
