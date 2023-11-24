package com.eidiko.niranjana.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eidiko.niranjana.entity.UsersData;


public interface UsersDataRepo extends JpaRepository<UsersData, String> 
{

	public Optional<UsersData>findUsersDataByUsersname(String name);
}
