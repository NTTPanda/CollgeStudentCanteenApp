package com.example.CanteenCollegeApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http

                .csrf(csrf -> csrf.disable()) // Disable CSRF for APIs
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/admin-login",
                                "/api/auth/student-login",
                                "/student/**",
                                "/feedback/**",
                                "/menutable/**",
                                "/orders/**",
                                "/analysis/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}


