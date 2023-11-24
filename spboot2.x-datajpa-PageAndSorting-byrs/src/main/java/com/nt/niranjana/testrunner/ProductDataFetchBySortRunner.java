package com.nt.niranjana.testrunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.nt.niranjana.entity.Product;
import com.nt.niranjana.repo.ProductRepo;
//@Component
public class ProductDataFetchBySortRunner  implements CommandLineRunner{

	@Autowired
	private ProductRepo repo;
	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println("Class name: "+repo.getClass().getName());
		
		//select *from prod_vendor order by pcode asc;
			//create Sort object
			Sort asce = Sort.by("pcode");	
			//call findAll method with Sort object
			Iterable<Product> list = repo.findAll(asce);
			//print
			for(Product p : list)
			{
				System.out.println("Data0: "+p);
			}
//==========================================================
		//select *from prod_vendor order by pid asc,pcode asc;
			//create Sort object
			Sort asceMultiple = Sort.by("pid","pcode");	
			//call findAll method with Sort object
			Iterable<Product> list1 = repo.findAll(asceMultiple);
			//print
			for(Product p1 : list1)
			{
				System.out.println("Data1: "+p1);
			}
			
//==================================================================================			
		//select *from prod_vendor order by pcode desc;
			//create Sort object
			Sort descending = Sort.by("pcode").descending();	
			//call findAll method with Sort object
			Iterable<Product> list2 = repo.findAll(descending);
			//print
			for(Product p2 : list2)
			{
				System.out.println("Data2: "+p2);
			}
//==================================================================================			
			//select *from prod_vendor order by vendor desc using Direction;
			//create Sort object
			Sort descending2 = Sort.by(Direction.DESC,"pcode");	
			//call findAll method with Sort object
			Iterable<Product> list3 = repo.findAll(descending2);
			//print
			for(Product p3 : list3)
			{
				System.out.println("Data3: "+p3);
			}
//==================================================================================			
		//select *from prod_vendor order by pid desc,pcost desc;
			//create Sort object
			Sort descending3= Sort.by(Direction.DESC,"pid","pcode");	
			//call findAll method with Sort object
			Iterable<Product> list4 = repo.findAll(descending3);
			//print
			for(Product p4 : list4)
			{
				System.out.println("Data4: "+p4);
			}
			
//==================================================================================			
			//select *from prod_vendor order by pid asc,pcode desc;
				//create Sort object
				Sort descending4= Sort.by(Order.desc("pid"),Order.asc("pcode"));	
				//call findAll method with Sort object
				Iterable<Product> list5 = repo.findAll(descending4);
				//print
				for(Product p5 : list5)
				{
					System.out.println("Data5: "+p5);
				}			
		
	}

}
//internal query
//select product0_.pid as pid1_0_, product0_.pcode as pcode2_0_, product0_.pcost as pcost3_0_, product0_.vendor as vendor4_0_ 
//from prod_vendor product0_ order by product0_.pcode desc



//pageable = page number + page size. Pageable is a interface so it impl class i.e PageRequest we use.PageRequest has one static method i.e of() which takes page number + page size.
//page? page is output of Pagination given by Database which stored inside Page object which contains Data and MetaData. 