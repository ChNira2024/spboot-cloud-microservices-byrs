package com.nt.niranjana.kafka.consumer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.niranjana.kafka.consumer.model.Patient;

public interface PatientKafkaRepo extends JpaRepository<Patient, Integer> 
{

}