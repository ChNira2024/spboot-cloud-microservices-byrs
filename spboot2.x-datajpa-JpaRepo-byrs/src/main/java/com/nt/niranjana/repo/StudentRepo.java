package com.nt.niranjana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.niranjana.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>
{

}
