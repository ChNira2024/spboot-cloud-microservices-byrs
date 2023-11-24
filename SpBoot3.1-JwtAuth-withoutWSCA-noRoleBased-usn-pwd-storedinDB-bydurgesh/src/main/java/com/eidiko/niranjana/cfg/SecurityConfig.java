package com.eidiko.niranjana.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.eidiko.niranjana.security.JwtAuthenticationEntryPoint;
import com.eidiko.niranjana.security.JwtAuthenticationFilter;
import com.eidiko.niranjana.service.CustomUsersDetailsService;

@Configuration
public class SecurityConfig 
{	
    @Autowired
    private JwtAuthenticationEntryPoint point;
    
    @Autowired
    private JwtAuthenticationFilter filter;
    
    @Autowired
	private CustomUsersDetailsService customUsersDetailsService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
    {
        http.csrf(csrf -> csrf.disable()).cors(cors->cors.disable())
        .authorizeHttpRequests(auth->auth.requestMatchers("/auth/login").permitAll()
        								.requestMatchers("/users/createuser").permitAll()
        								.requestMatchers("/users/listOfData").authenticated()  
                .anyRequest()
                .authenticated())
                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    
    @Bean
    public DaoAuthenticationProvider authProvider() 
	{
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUsersDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

}