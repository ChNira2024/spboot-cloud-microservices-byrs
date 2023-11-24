package com.nt.niranjana.consumer.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.niranjana.consumer.entity.IPLPlayer;



public interface IPLPlayerRepository extends JpaRepository<IPLPlayer,Integer> 
{

}