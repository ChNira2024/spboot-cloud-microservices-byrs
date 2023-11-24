package com.nt.niranjana.repo;


import org.springframework.data.repository.CrudRepository;

import com.nt.niranjana.entity.Movie;


public interface IMovieRepo extends CrudRepository<Movie,Integer> 
{

}