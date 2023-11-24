package com.eidiko.niranjana.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="user_table")
public class UsersData
{

	@Id
	private String id;
	private String usersname;
	private String email;
	private String password;
	private String about;
	
}
