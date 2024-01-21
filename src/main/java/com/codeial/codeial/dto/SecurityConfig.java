package com.codeial.codeial.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.codeial.codeial.jwtsecurity.JwtAuthenticationEntryPoint;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;

    @SuppressWarnings("deprecation")
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeRequests()
                	.requestMatchers("/login").permitAll()
	                .requestMatchers("/signup").permitAll()
	                .anyRequest().authenticated() //any other url apart from /logn, /signup needs authentication
                .and()
                .exceptionHandling(ex -> ex.authenticationEntryPoint(point)) //configuring custom entry point "entry" for handling exception
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class); //adding custom "filter" before UsernamePasswordAuthenticationFilter filter in filter chain
        return http.build(); //returns the fully configured HttpSecurity object/bean, and it is then interpreted by Spring as the definition of the SecurityFilterChain
    }
}
