package com.azapienc.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.azapienc.security.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

  private UserRepository userRepository;

  @Bean
  public UserDetailsService userDetailsService() {
    return username -> userRepository
        .findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found..."));
  }
}
