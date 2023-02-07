package com.example.budgetLesh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


// by class WebSecurityConfig we ensure that only authenticated users can see data
// this class configures WebSecurity at the start of web application and send httpSecurity object
//
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // switch on authorization
                .authorizeHttpRequests((requests) -> requests
                        // full access for authorized user
                        .requestMatchers("/").permitAll()
                        // for not authorized user we ask authorization
                        .anyRequest().authenticated()
                )
                // create login form for not authorized user with address "/login" and give all permissions
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                // create logout method and give all permissions
                .logout((logout) -> logout.permitAll());

        return httpSecurity.build();
    }

    // manage user data in memory
    // withDefaultPasswordEncoder method create user every time we run application to testing and so on
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("1")
                        .password("1")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
