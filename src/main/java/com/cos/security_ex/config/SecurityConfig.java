package com.cos.security_ex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
   
   @Bean
   public BCryptPasswordEncoder encodePwd(){
      return new BCryptPasswordEncoder();
   }

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

      http
         .csrf(csrf -> csrf.disable())
         .authorizeHttpRequests(auth -> auth
            .requestMatchers("/user/**").authenticated()
            .requestMatchers("/admin/**").hasRole("/ADMIN")
            .anyRequest().permitAll()
         ).formLogin(login -> login
            .loginPage("/loginForm")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/")
            .permitAll()
         );

         return http.build();


   }

}
