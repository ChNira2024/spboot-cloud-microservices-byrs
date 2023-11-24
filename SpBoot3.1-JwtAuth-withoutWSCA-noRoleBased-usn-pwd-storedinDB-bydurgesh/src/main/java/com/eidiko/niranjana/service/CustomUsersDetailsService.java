package com.eidiko.niranjana.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eidiko.niranjana.entity.UsersData;
import com.eidiko.niranjana.repo.UsersDataRepo;
@Service
public class CustomUsersDetailsService implements UserDetailsService 
{

	@Autowired
	private UsersDataRepo userREpo;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException 
	{
		UsersData user = userREpo.findUsersDataByUsersname(name).orElseThrow(()->new RuntimeException("User Not Found !!"));
		if(user == null)
		{
			throw new UsernameNotFoundException(name); 
		}
		return new CustomUsersDetails(user);
	}

}
