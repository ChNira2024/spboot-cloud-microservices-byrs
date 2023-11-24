package com.nt.niranjana.producer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.niranjana.producer.entity.IPLTeam;
import com.nt.niranjana.producer.repo.IPLTeamRepository;
import com.nt.niranjana.producer.service.IPLTeamMgmtService;


@Service("teamService")
public class IPLTeamMgmtServiceImpl implements IPLTeamMgmtService 
{
	@Autowired
	private IPLTeamRepository  teamRepo;

	@Override
	public String saveTeam(IPLTeam team) 
	{
		return "team is saved with:"+ teamRepo.save(team).getTeamId();
	}

	@Override
	public IPLTeam findTeamById(int id) 
	{
		/*	Optional<IPLTeam> opt=teamRepo.findById(id);
			if(opt.isPresent())
				return opt.get();
			else
				throw new IllegalArgumentException("invalid team id");
		*/
		return  teamRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid team id"));
		
	}

	@Override
	public Iterable<IPLTeam> findAllTeams() 
	{
	
		return teamRepo.findAll();
	}

}