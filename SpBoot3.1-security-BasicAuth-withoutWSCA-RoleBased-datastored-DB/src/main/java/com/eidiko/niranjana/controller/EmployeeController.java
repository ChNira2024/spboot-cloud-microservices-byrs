package com.eidiko.niranjana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.niranjana.dto.Employee;
import com.eidiko.niranjana.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService service;

	@GetMapping("/fetchEmployeeAllData")
	public List<Employee> fetchAllEmployeeDataFromDB() {
		List<Employee> list = service.fetchAllEmployeeData();
		return list;
	}

	//@PreAuthorize("hasRole('ADMIN')")  //IF YOU USE THIS ANNOTATION THEN YOU MUST USE @EnableMethodSecurity in top of the controller class
		@GetMapping("/fetchEmployeeData/{id}")
		public ResponseEntity<List<Employee>> fetchEmployeeData(@PathVariable String id)
		{
			List<Employee> data = service.fetchEmployeesDataByUsingID(id);
			return new ResponseEntity<List<Employee>>(data,HttpStatus.OK);		
		}
}
