package com.eidiko.niranjana.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.niranjana.model.UsersData;
import com.eidiko.niranjana.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersDataController 
{
	@Autowired
	private UserService service;

	//To know the current user name
	@GetMapping("/currentuser")
	public String getCurrentUserName(Principal principal)
	{
		return "Current User Name is: "+principal.getName();
	}
	
	@GetMapping("/listOfData")
	public List<UsersData> getListOfUsers()
	{
		return service.getUser();
	}
}
