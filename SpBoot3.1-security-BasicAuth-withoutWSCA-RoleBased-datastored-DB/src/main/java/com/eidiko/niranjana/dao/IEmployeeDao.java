package com.eidiko.niranjana.dao;

import java.util.List;

import com.eidiko.niranjana.dto.Employee;

public interface IEmployeeDao 
{
	public List<Employee> fetchAllEmployeeData();
	
	public List<Employee> fetchEmployeeCrudFromDBUsingID(String id);

}
