package com.example.AuthenticationApi.Service;

import org.springframework.stereotype.Service;

import com.example.AuthenticationApi.Model.Role;

@Service
public class RoleServiceImplt implements RoleService {

    Role role = new Role();

    @Override
    public String setRole(String roleName) {
        role.setName(roleName);
        return roleName;
    }

}
