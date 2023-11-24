package com.nt.niranjana.producer.service;

import com.nt.niranjana.producer.entity.IPLTeam;

public interface IPLTeamMgmtService 
{
    public   String  saveTeam(IPLTeam team);
    public   IPLTeam findTeamById(int id);
    public   Iterable<IPLTeam>  findAllTeams();
}