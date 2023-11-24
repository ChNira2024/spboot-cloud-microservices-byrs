package com.nt.niranjana.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student 
{
	@Id
	private Integer stdId;
	
	private String stdName;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Temporal(TemporalType.TIME)
	private Date time;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	
}
//NOTE: if u use Date class but u did not specify any @Temporal then default will be TIMESTAMP