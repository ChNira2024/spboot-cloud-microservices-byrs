package com.nt.niranjana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.niranjana.entity.User;
import com.nt.niranjana.entity.service.IUserService;

@RestController
@RequestMapping("/v1/api/users")
public class UserRestController
{
	@Autowired
	private IUserService userService;
	
	@PostMapping("/create")
	public String createUser(@RequestBody User user)
	{
		Integer id= userService.saveUser(user);
		return "User "+id+" created!";
	}
	
	@GetMapping("/find/{id}")
	public User findOneUser(@PathVariable Integer id)
	{
		return userService.getOneUserByID(id);
	}
	
	@PutMapping("/modify")
	public String updateUser(@RequestBody User user)
	{
		userService.updateUser(user.getId(), user);
		return "User iD "+user.getId()+" Updated!";
	}
	
	@DeleteMapping("/remove/{id}")
	public String deleteOneUser(@PathVariable Integer id)
	{
		 userService.deleteUserByID(id);
		 return "User "+id+" Deleted!";
	}

}
