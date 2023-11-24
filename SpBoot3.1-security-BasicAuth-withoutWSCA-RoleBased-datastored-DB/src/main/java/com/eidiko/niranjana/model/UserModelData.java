//package com.eidiko.niranjana.model;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.eidiko.niranjana.entity.UserEntityData;
//
//public class UserModelData {
//	
//	private String empName;
//	private String empPassword;
//	private String empEmail;
//	private String empRole;
//	
//	public String getEmpName() {
//		return empName;
//	}
//
//	public void setEmpName(String empName) {
//		this.empName = empName;
//	}
//
//	public String getEmpPassword() {
//		return empPassword;
//	}
//
//	public void setEmpPassword(String empPassword) {
//		this.empPassword = empPassword;
//	}
//
//	public String getEmpEmail() {
//		return empEmail;
//	}
//
//	public void setEmpEmail(String empEmail) {
//		this.empEmail = empEmail;
//	}
//
//	public String getEmpRole() {
//		return empRole;
//	}
//
//	public void setEmpRole(String empRole) {
//		this.empRole = empRole;
//	}
//
//	public BCryptPasswordEncoder getPaswordEncoder() {
//		return paswordEncoder;
//	}
//
//	public void setPaswordEncoder(BCryptPasswordEncoder paswordEncoder) {
//		this.paswordEncoder = paswordEncoder;
//	}
//
//	@Override
//	public String toString() {
//		return "UserModelData [empName=" + empName + ", empPassword=" + empPassword + ", empEmail=" + empEmail
//				+ ", empRole=" + empRole + ", paswordEncoder=" + paswordEncoder + "]";
//	}
//
//	@Autowired
//	private  BCryptPasswordEncoder paswordEncoder;
//	
//	public static UserEntityData dtoUserEntity(UserModelData userModelData)
//	{
//		UserEntityData userEntity = new UserEntityData();
//		userEntity.setName(userModelData.getEmpName());
//		userEntity.setName(userModelData.getEmpPassword());
//		userEntity.setName(userModelData.getEmpEmail());
//		userEntity.setName(userModelData.getEmpPassword());
//		return userEntity;
//	}	
//
//}
