package com.eidiko.niranjana.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class BasicAuthenticationSecurityConfigCustomize_RoleBased_User_PW_WithDB
{
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Bean
	public BCryptPasswordEncoder passwordEncoder() 
	{
			return new BCryptPasswordEncoder();
	}
	
	@Bean
    public DaoAuthenticationProvider authProvider() 
	{
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/user/insertUserEntityDataIntoDB").hasRole("MANAGER")
		.requestMatchers("/employee/fetchEmployeeAllData","/employee/fetchEmployeeData/{id}").hasRole("DEV")
		.anyRequest()
		.authenticated()
	     .and().httpBasic();
	   //  .formLogin(); 
		return httpSecurity.build();
	}
}
