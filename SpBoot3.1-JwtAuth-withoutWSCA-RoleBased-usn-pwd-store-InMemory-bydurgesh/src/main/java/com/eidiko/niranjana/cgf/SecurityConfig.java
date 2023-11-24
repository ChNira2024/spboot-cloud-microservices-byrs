package com.eidiko.niranjana.cgf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.eidiko.niranjana.security.JwtAuthenticationEntryPoint;
import com.eidiko.niranjana.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig 
{	
    @Autowired
    private JwtAuthenticationEntryPoint point;
    
    @Autowired
    private JwtAuthenticationFilter filter;
    
    @Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception 
	{
	    return http.getSharedObject(AuthenticationManagerBuilder.class)
	            .build();
	}
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
    {
        http.csrf(csrf -> csrf.disable()).cors(cors->cors.disable())
        .authorizeHttpRequests(auth->auth.requestMatchers("/users/listOfData").hasRole("DEV")
        		                         .requestMatchers("/auth/login").permitAll()
                .anyRequest()
                .authenticated())
                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}