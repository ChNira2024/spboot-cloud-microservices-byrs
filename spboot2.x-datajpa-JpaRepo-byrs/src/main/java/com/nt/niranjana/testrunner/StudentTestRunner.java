package com.nt.niranjana.testrunner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.niranjana.entity.Student;
import com.nt.niranjana.repo.StudentRepo;
@Component
public class StudentTestRunner implements CommandLineRunner
{
	@Autowired
	private StudentRepo repo;
	
	@Override
	public void run(String... args) throws Exception 
	{
		repo.save(new Student(101,"Raja",new Date(),new Date(),new Date()));

	}

}
