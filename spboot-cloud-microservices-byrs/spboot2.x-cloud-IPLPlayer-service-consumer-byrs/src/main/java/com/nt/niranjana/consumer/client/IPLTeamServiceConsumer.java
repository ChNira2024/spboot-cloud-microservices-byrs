package com.nt.niranjana.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nt.niranjana.consumer.entity.IPLTeam;


@FeignClient("IPL-TEAM-SERVICE-PRODUCER")
public interface IPLTeamServiceConsumer 
{
	
	@GetMapping("/team/search/{id}")
     public   ResponseEntity<IPLTeam>  searchTeamById(@PathVariable("id") int id) ;
}