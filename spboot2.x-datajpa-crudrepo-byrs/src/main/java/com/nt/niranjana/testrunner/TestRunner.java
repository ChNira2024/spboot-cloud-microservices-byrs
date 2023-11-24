package com.nt.niranjana.testrunner;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.niranjana.entity.Product;
import com.nt.niranjana.repo.ProductRepo;
@Component
public class TestRunner  implements CommandLineRunner{

	@Autowired
	private ProductRepo repo;
	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println("Class name: "+repo.getClass().getName());
		repo.save(new Product(105,"MOBILE", 305.86));
		repo.save(new Product(106,"PEN", 305.86));
		
		//using saveAll we can insert list of data at a time(asList() comes in jdk 1.2
		//repo.saveAll(Arrays.asList(new Product(105,"MOBILE", 305.86),new Product(106,"PEN", 305.86),new Product(106,"PEN", 305.86)));
		
		//using List.of() we can insert list of data at a time(asList() comes in jdk 1.9
		//repo.List.of(Arrays.asList(new Product(105,"MOBILE", 305.86),new Product(106,"PEN", 305.86),new Product(106,"PEN", 305.86)));
		
		/************** COUNT and EXIST ************************/
		System.out.println("EXIST? :"+repo.existsById(2));
		System.out.println("ROW COUNT :"+repo.count());

		/************** BASIC FIND METHODS ************************/
		Optional<Product> opt=repo.findById(3);
		if(opt.isPresent()) //used this for avoid Null pointer EXception
		{
			Product p = opt.get();
			System.out.println(p);
		}
		else 
		{
			System.out.println("NO DATA FOUND");
		}
		//to iterate the list of data using method reference
		Iterable<Product> itr = repo.findAll();
		itr.forEach(System.out::println);
		
		//to iterate the list of data using lambda expression
		Iterable<Product> itr2 = repo.findAll();
		itr2.forEach(ob->System.out.println(ob));

		//to iterate the list of data using iterator
		Iterator<Product> it= itr.iterator();
		while(it.hasNext())
		{
			Product pt = it.next();
			System.out.println(pt);
		}
		
		//to iterate the list of data using method reference in single line
		repo.findAll().forEach(System.out::println);
		
		//iterate data by using multiple id 
		Iterable<Product> list =repo.findAllById(List.of(105,106));
		System.out.println("List:"+list);//fetch at a time
		list.forEach(System.out::println);//fetch one by one

		/************** DELETE ************************/

		//.deleteById(3); //repo.deleteAll(); repo.deleteAllInBatch();

		//System.out.println("--delete -- finished");
		
		//repo.delete(repo.findById(105).orElseThrow(()->new PropductNotFoundException("Product is Not Exist")));

		//System.exit(0);
		
	}

}
