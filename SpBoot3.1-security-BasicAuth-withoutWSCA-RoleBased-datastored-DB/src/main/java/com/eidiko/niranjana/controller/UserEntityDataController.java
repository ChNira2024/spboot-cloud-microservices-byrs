package com.eidiko.niranjana.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.niranjana.entity.UserEntityData;
import com.eidiko.niranjana.repo.UserEntityRepo;

@RestController
@RequestMapping(value="/user")
public class UserEntityDataController 
{

	@Autowired
	private UserEntityRepo repo;
	
	@Autowired
	private  BCryptPasswordEncoder paswordEncoder;
	
	@PostMapping("/insertUserEntityDataIntoDB")                                //List<UserModelData> userModelData
	public UserEntityData saveUserEntityDataIntoDB(@RequestBody UserEntityData userEntityData)
	{
		UserEntityData user1 = new UserEntityData();
		user1.setName(userEntityData.getName());
		user1.setPassword(paswordEncoder.encode(userEntityData.getPassword()));
		user1.setEmail(userEntityData.getEmail());
		user1.setRole(userEntityData.getRole());
		return  repo.save(user1);
		/*
		List<UserEntityData> userEntities = new ArrayList<>();
		for (UserModelData user : userModelData) 
		{
	        userEntities.add(UserModelData.dtoUserEntity(user));
	    }

	    Iterable<UserEntityData> persistedUser = repo.saveAll(userEntities);
	    System.out.println("persistedUser"+persistedUser);
		*/
	}
}
