package com.example.AuthenticationApi.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.AuthenticationApi.Service.UserDetailsSvc;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired
  private UserDetailsSvc userDetailsService;

  public SecurityConfig(UserDetailsSvc userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  // @Bean
  // public UserDetailsService userDetailsService() {
  // return new UserDetailsSvc();
  // }

  // @Bean
  // public DaoAuthenticationProvider authenticationProvider() {
  // DaoAuthenticationProvider daoAuthenticationProvider = new
  // DaoAuthenticationProvider();
  // daoAuthenticationProvider.setUserDetailsService(userDetailsService());
  // return daoAuthenticationProvider;
  // }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((request) -> request
            .requestMatchers("/css/**", "/images/**", "/signUp", "/signUpEmail", "/")
            .permitAll()
            .anyRequest().authenticated())
        .formLogin((form) -> form
            .loginPage("/login")
            .defaultSuccessUrl("/welcome")
            .failureUrl("/fail")
            .usernameParameter("email")
            .passwordParameter("password")
            .permitAll())
        .csrf(AbstractHttpConfigurer::disable);
    return http.build();
  }

  @Bean
  public AuthenticationManager authenticationManager(
      AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // @Bean
  // public AuthenticationManager
  // authenticationManager(AuthenticationConfiguration
  // authenticationConfiguration)
  // throws Exception {
  // return authenticationConfiguration.getAuthenticationManager();
  // }

  // @Bean
  // public UserDetailsService userDetailsService() {

  // return new UserDetailsSvc();
  // }
}