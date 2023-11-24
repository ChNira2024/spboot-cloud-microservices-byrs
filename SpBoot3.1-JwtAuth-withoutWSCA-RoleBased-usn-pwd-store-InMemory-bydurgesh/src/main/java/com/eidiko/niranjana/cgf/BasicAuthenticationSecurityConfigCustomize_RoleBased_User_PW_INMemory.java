package com.eidiko.niranjana.cgf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class BasicAuthenticationSecurityConfigCustomize_RoleBased_User_PW_INMemory
{
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() 
	{
			return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailService() 
	{	
		UserDetails manager = User.builder().username("niranjana").password(passwordEncoder().encode("niranjana")).roles("MANAGER").build();
		UserDetails developer = User.builder().username("susantaa").password(passwordEncoder().encode("susantaa")).roles("DEV").build();
		//InMemoryUserDetailsManager inMemoryuserdetailsManager = new InMemoryUserDetailsManager(manager,developer);
		//return inMemoryuserdetailsManager(manager,developer);
		return new InMemoryUserDetailsManager(manager,developer);		
	}
}
