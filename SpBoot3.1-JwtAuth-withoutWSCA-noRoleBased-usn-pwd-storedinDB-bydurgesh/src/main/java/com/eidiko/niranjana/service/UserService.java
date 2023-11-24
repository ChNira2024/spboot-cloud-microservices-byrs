package com.eidiko.niranjana.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eidiko.niranjana.entity.UsersData;
import com.eidiko.niranjana.repo.UsersDataRepo;

@Service
public class UserService 
{
	@Autowired
	private UsersDataRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public UsersData createUser(UsersData userData)
	{
		userData.setId(UUID.randomUUID().toString());
		userData.setPassword(passwordEncoder.encode(userData.getPassword()));
		return repo.save(userData);
	}
	
	public List<UsersData> getUser()
	{
		return repo.findAll();
	}
}
