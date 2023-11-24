package com.nt.niranjana.entity.service;

import com.nt.niranjana.entity.User;

public interface IUserService 
{
	Integer saveUser(User user);
	
	User getOneUserByID(Integer userId);
	
	void updateUser(Integer userId,User user);
	
	void deleteUserByID(Integer userID );
}
