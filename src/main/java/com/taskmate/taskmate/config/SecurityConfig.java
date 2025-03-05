// package com.taskmate.taskmate.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     // Define a SecurityFilterChain bean for configuring HTTP security
//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .authorizeRequests()
//             .requestMatchers("/swagger-ui/**", "/v3/api-docs/**")  // Use requestMatchers instead of antMatchers
//             .permitAll()
//             .anyRequest().authenticated()  // Require authentication for all other requests
//             .and()
//             .formLogin().permitAll()  // Enable form login
//             .and()
//             .httpBasic();  // Enable HTTP Basic Authentication

//         return http.build();
//     }
// }
