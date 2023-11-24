package com.nt.niranjana.kafka.producer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.niranjana.kafka.producer.model.Patient;

public interface PatientKafkaRepo extends JpaRepository<Patient, Integer> 
{

}