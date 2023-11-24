package com.eidiko.niranjana.service;

import java.util.List;

import com.eidiko.niranjana.dto.Employee;

public interface IEmployeeService 
{
	public List<Employee>fetchAllEmployeeData();
	public List<Employee> fetchEmployeesDataByUsingID(String id);

}
