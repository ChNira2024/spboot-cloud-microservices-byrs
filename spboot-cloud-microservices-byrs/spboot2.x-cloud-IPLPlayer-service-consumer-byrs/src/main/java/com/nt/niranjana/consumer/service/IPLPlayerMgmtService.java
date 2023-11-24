package com.nt.niranjana.consumer.service;

import com.nt.niranjana.consumer.entity.IPLPlayer;

public interface IPLPlayerMgmtService 
{
	public   String registerPlayer(IPLPlayer player);
    public  Iterable<IPLPlayer> showAllPlayers();
}