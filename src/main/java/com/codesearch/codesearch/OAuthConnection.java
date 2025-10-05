package com.codesearch.codesearch;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableWebSecurity
public class OAuthConnection {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http
              .authorizeHttpRequests(auth -> auth
                      .requestMatchers("/").permitAll()
                      .anyRequest().authenticated()
              )
              .oauth2Login(oauth2 -> oauth2
                      // redirect after login
                      .defaultSuccessUrl("/", true)
              )
              .logout(logout -> logout
                      .logoutSuccessUrl("/").permitAll()
              );
      return http.build();
  }

}



