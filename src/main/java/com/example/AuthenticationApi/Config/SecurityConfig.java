package com.example.AuthenticationApi.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.AuthenticationApi.Model.Role;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public static PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((request) -> request
            .requestMatchers("/", "/css/**", "/images/**", "/signUp", "/signUpEmail",
                "/login", "/welcome")
            .permitAll()
            .anyRequest().anonymous())
        .formLogin((form) -> form
            .loginPage("/login"))
        .csrf(AbstractHttpConfigurer::disable);
    // .failureUrl("/login")
    // .loginProcessingUrl("/login")
    // .defaultSuccessUrl("/signUp")
    // .usernameParameter("email")
    // .passwordParameter("password")
    // .permitAll())

    return http.build();
  }

}