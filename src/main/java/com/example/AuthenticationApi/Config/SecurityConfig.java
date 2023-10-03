package com.example.AuthenticationApi.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.HeaderWriter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  // Inject custom security config
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http

        .authorizeHttpRequests((request) -> request
            .requestMatchers("/css/**", "/images/**", "/signUp", "/signUpEmail", "/", "/js/**").permitAll()
            .requestMatchers("/user/**").hasAnyAuthority("ADMIN", "USER")
            .requestMatchers("/admin/**").hasAuthority("ADMIN")
            .anyRequest().authenticated())
        .formLogin((form) -> form
            .loginPage("/login")
            .defaultSuccessUrl("/user/welcome")
            .failureUrl("/fail")
            .usernameParameter("email")
            .passwordParameter("password")
            .permitAll())
        .csrf(AbstractHttpConfigurer::disable)
        .logout((logout) -> logout
            .invalidateHttpSession(true)
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login"))
        .headers((headers) -> headers
            .frameOptions(frameOptions -> frameOptions
                .sameOrigin()));
    return http.build();
  }

  
  // Inject Auth Manager
  @Bean
  public AuthenticationManager authenticationManager(
      AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  // inject password Encoder
  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}