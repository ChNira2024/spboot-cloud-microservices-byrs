package com.nt.niranjana.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="prod_vendor")
public class Product 
{
	@Id
	private Integer pid;
	
	private String pcode;
	private Double pcost;
	private String vendor;
	

}
