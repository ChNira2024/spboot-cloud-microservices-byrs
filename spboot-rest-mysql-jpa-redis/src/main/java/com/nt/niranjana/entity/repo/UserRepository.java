package com.nt.niranjana.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.niranjana.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
	
	

}
