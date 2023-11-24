package com.nt.niranjana.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.nt.niranjana.entity.Movie;


public interface IMovieMgmtService
{
  public  String registerMovie(List<Movie> movies);
  
  	//One method can have only one var arg param that to last param of the method
	  // Var args are internally arrays..
    public  Iterable<Movie>  displayMoviesByOrder(boolean asc,String ... properites);    
    public  Page<Movie>   generateReport(int pageNo,int pageSize,boolean asc,String ...props);
    public  void  generateMoviesReport(int pageSize);
  
  
}