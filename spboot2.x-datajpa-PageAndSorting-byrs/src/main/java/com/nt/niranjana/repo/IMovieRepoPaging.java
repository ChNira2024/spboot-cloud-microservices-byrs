package com.nt.niranjana.repo;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.niranjana.entity.Movie;


public interface IMovieRepoPaging extends PagingAndSortingRepository<Movie,Integer> 
{

}