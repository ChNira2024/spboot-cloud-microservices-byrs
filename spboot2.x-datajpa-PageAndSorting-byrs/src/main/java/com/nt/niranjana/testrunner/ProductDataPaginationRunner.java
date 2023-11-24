package com.nt.niranjana.testrunner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.nt.niranjana.entity.Product;
import com.nt.niranjana.repo.ProductRepo;

//@Component
public class ProductDataPaginationRunner implements CommandLineRunner 
{
	@Autowired
	private ProductRepo repo;

	@Override
	public void run(String... args) throws Exception 
	{
		Pageable pageable = PageRequest.of(2, 3);//here two param is page-number/page-index 2 and page size is 3
		Page<Product> page=repo.findAll(pageable);
		
		//methods in page
			//get the content/data
			List<Product> listOfdata=page.getContent();
			listOfdata.forEach(System.out::println);
			
		//meta data
			System.out.println();
			System.out.println("Is First Page: "+page.isFirst());
			System.out.println("Is Last Page: "+page.isLast());
			System.out.println("Has Next Page: "+page.hasNext());
			System.out.println("Has Previous Page: "+page.hasPrevious());
			System.out.println("Total Page: "+page.getTotalPages());
			System.out.println("Total Row: "+page.getTotalElements());
			System.out.println("Current Page Number: "+page.getNumber());
			System.out.println("Current Page Size: "+page.getSize());
	}

}
//here two param is page-number/page-index 2 and page size is 3 --->it means data row will partitioned by page size then display based index.
//index starts from 0
