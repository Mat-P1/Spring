package com.spring.udemy.security.mvcsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    // Hard coded users, roles and passwords (For learning purposes)
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }

    // Custom login page

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer -> configurer
                        .anyRequest().authenticated())
                        .formLogin(form -> form
                                  .loginPage("/loginPage")
                                  .loginProcessingUrl("/authenticateUser")
                                  .permitAll())
                        .logout(LogoutConfigurer::permitAll);
        return http.build();
    }
}
