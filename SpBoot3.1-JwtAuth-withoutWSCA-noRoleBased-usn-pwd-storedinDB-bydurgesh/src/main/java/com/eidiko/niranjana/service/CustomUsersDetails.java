package com.eidiko.niranjana.service;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.eidiko.niranjana.entity.UsersData;

public class CustomUsersDetails implements UserDetails 
{

	private UsersData user;
	
	public CustomUsersDetails(UsersData user)
	{
		this.user=user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//HashSet<SimpleGrantedAuthority> set = new HashSet<>();
		//set.add(new SimpleGrantedAuthority(this.user.));
		return null;
	}

	@Override
	public String getPassword() 
	{
		return user.getPassword();
	}

	@Override
	public String getUsername() 
	{
		return user.getUsersname();
	}

	@Override
	public boolean isAccountNonExpired() 
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked() 
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() 
	{
		return true;
	}

	@Override
	public boolean isEnabled() 
	{
		return true;
	}
}
