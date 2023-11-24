package com.nt.niranjana.service.impl;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.niranjana.entity.Movie;
import com.nt.niranjana.repo.IMovieRepo;
import com.nt.niranjana.repo.IMovieRepoPaging;
import com.nt.niranjana.service.IMovieMgmtService;


@Service("movieService")
public class MovieMgmtServiceImpl implements IMovieMgmtService 
{
	@Autowired    //injects the dynamically generated proxy class object 
	private IMovieRepo  movieRepo;  //HAS-A proeprty
	
	@Autowired
	private IMovieRepoPaging movieRepoPaging;

	@Override
	public String registerMovie(List<Movie> movies) 
	{
		System.out.println("InMemory Proxu class name::"+movieRepo.getClass()+"..........."+Arrays.toString(movieRepo.getClass().getInterfaces()));
		   //use repo
		 System.out.println("bfore saving::"+movies);
		    Iterable<Movie> listOfMovies=movieRepo.saveAll(movies);
		    System.out.println("after saving::"+listOfMovies);
		    for(Movie aj : listOfMovies)
		    {
		    	System.out.println(" Move is registered with the Id Value::"+aj.getMid());
		    	return " Move is registered with the Id Value::"+aj.getMid();
		    }
		    
		    return null;
	}
	
	@Override
	public Iterable<Movie> displayMoviesByOrder(boolean asc, String... properites)
	{
		   Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC, properites);
		return movieRepoPaging.findAll(sort);
	}
		
	
	@Override
	public Page<Movie> generateReport(int pageNo, int pageSize, boolean asc, String... props)
	{
		//create Pageable object
	     Pageable pageable=PageRequest.of(pageNo, pageSize,Sort.by(asc?Direction.ASC:Direction.DESC, props));
	     // get requested page records
	     Page<Movie> page=movieRepoPaging.findAll(pageable);
		return page;
	}
	
	@Override
	public void generateMoviesReport(int pageSize) 
	{
		 //get count of records
		 long recordsCount=movieRepo.count();
		 //decide no.of pages (pagesCount)
		 long pagesCount=0;
	 if(pageSize>=1) 
	 {
		 pagesCount=recordsCount/pageSize;
		 // get exact pagesCount
		 pagesCount=recordsCount%pageSize==0?pagesCount:++pagesCount;
	 }
	 else
	 {
		 throw new IllegalArgumentException("PageSize can not be <=Zero");
	 }
		 
		 for(int pageNo=0;pageNo<pagesCount;++pageNo) 
		 {
			 //prepare pageable object
			 Pageable pageable=PageRequest.of(pageNo, pageSize);
			 Page<Movie> page=movieRepoPaging.findAll(pageable);
			 	 System.out.println("---- page no::"+(pageNo+1)+" pageSize: "+pageSize+" pageRecords count:: "+page.getNumberOfElements()+"------");
			 	 List<Movie> list=page.getContent();
			 	 list.forEach(movie->{
			 		 System.out.println(movie);
			 	 });
		 }//for
		 
	}//method
	
	
	
	
}