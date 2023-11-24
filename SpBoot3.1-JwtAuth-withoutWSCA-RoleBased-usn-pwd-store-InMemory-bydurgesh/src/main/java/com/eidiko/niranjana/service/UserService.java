package com.eidiko.niranjana.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.eidiko.niranjana.model.UsersData;

@Service
public class UserService 
{
	private List<UsersData> store = new ArrayList<>();
	
	public UserService() 
	{
		store.add(new UsersData(UUID.randomUUID().toString(),"Jacksparow","jacksparow@gmail.com"));
		store.add(new UsersData(UUID.randomUUID().toString(),"Peterson","peterson@gmail.com"));
		store.add(new UsersData(UUID.randomUUID().toString(),"David","david@gmail.com"));
	}
	
	public List<UsersData> getUser()
	{
		return this.store;
	}

}
