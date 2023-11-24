//package com.eidiko.niranjana.dto;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.eidiko.niranjana.entity.UserEntityData;
//import com.eidiko.niranjana.model.UserModelData;
//
//public class UserEntityDTO
//{
//	@Autowired
//	private BCryptPasswordEncoder paswordEncoder;
//	
//	public UserEntityData dtoUserEntity(UserModelData userModelData)
//	{
//		UserEntityData userEntity = new UserEntityData();
//		userEntity.setName(userModelData.getName());
//		userEntity.setName(userModelData.getPassword());
//		userEntity.setName(userModelData.getEmail());
//		userEntity.setName(paswordEncoder.encode(userModelData.getPassword()));
//		return userEntity;
//	}	
//
//}
