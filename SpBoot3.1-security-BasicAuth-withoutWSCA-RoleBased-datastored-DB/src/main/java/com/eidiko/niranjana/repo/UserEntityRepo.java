package com.eidiko.niranjana.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eidiko.niranjana.entity.UserEntityData;


public interface UserEntityRepo extends JpaRepository<UserEntityData, String> 
{

	public UserEntityData getUserByName(String username);
}
