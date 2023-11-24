package com.eidiko.niranjana.cfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eidiko.niranjana.entity.UserEntityData;
import com.eidiko.niranjana.repo.UserEntityRepo;
@Service
public class CustomUserDetailsService implements UserDetailsService 
{

	@Autowired
	private UserEntityRepo userREpo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		UserEntityData user = userREpo.getUserByName(username);
		if(user == null)
		{
			throw new UsernameNotFoundException(username); 
		}
		return new CustomUserDetails(user);
	}

}
