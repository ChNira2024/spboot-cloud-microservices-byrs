package com.nt.niranjana.entity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.nt.niranjana.entity.User;
import com.nt.niranjana.entity.repo.UserRepository;
import com.nt.niranjana.entity.service.IUserService;

@Service
public class UserServiceImpl implements IUserService
{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public Integer saveUser(User user) 
	{
		return userRepo.save(user).getId();
	}

	@Cacheable(value="users",key="#userId")
	@Override
	public User getOneUserByID(Integer userId) 
	{
		return userRepo.findById(userId).get();
	}

	@CachePut(value="users",key="#userId")
	@Override
	public void updateUser(Integer userId, User user) 
	{
		User userDB = userRepo.findById(userId).get();
		userDB.setName(user.getName());
		userDB.setRole(user.getRole());
		userRepo.save(userDB);
	}
	
	@CacheEvict(value="users",allEntries = true)
	@Override
	public void deleteUserByID(Integer userID) 
	{
		 userRepo.deleteById(userID);
	}

}
