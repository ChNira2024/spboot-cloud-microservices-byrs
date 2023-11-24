package com.nt.niranjana.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User implements Serializable
{

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String role;
}
