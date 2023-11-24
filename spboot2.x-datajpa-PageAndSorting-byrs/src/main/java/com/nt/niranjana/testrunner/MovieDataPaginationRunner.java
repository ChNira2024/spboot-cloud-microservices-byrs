package com.nt.niranjana.testrunner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.niranjana.entity.Movie;
import com.nt.niranjana.service.IMovieMgmtService;
@Component
public class MovieDataPaginationRunner implements CommandLineRunner
{
	@Autowired
	private IMovieMgmtService movieService;

	@Override
	public void run(String... args) throws Exception 
	{
		//invoke sevice method
		 /*
		 List<Movie> listOfMovie =  List.of(new Movie("RRR","2022",4.5f),
				  new Movie("PATHAN","2023",4.5f),
				  new Movie("TIGER-3","2023",4.5f),
				  new Movie("JAWAN","2021",4.2f),
				  new Movie("BHAIJAAN","2020",4.0f));
		  try 
		  {
			  System.out.println(movieService.registerMovie(listOfMovie));
		  }
		  catch(Exception e) 
		  {
			  e.printStackTrace();
		  }
		  */
		  
		  System.out.println("----------findAll(Sort sort)-------");
			try 
			{
			Iterable<Movie> it=movieService.displayMoviesByOrder(false,"year","mname");
			it.forEach(System.out::println);
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
			
			System.out.println("----------findAll(Pageable pageable)-------");
			try 
			{
			 Page<Movie> page=movieService.generateReport(2, 3, true, "mname");
			 System.out.println("page number::"+page.getNumber());
			 System.out.println("pages count::"+page.getTotalPages());
			 System.out.println("is it first page::"+page.isFirst());
			 System.out.println("is it last page::"+page.isLast());
			 System.out.println("page Size::"+page.getSize());
			 System.out.println("page Elements count::"+page.getNumberOfElements());
			 if(!page.isEmpty()) 
			 {
			   
			    List<Movie> list=page.getContent();
			    list.forEach(System.out::println);
			 }
			 else
				 System.out.println("no page found");
			}//try
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		
		System.out.println("----------findAll(Pageable pageable)-------");
		try {
			movieService.generateMoviesReport(1);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	

}
