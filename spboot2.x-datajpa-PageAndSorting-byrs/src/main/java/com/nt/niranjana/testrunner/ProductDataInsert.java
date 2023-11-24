package com.nt.niranjana.testrunner;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.nt.niranjana.entity.Product;
import com.nt.niranjana.repo.ProductRepo;
//@Component
public class ProductDataInsert  implements CommandLineRunner{

	@Autowired
	private ProductRepo repo;
	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println("Class name: "+repo.getClass().getName());
		repo.save(new Product(101,"MOBILE", 12000.00,"FILPKART"));
		repo.save(new Product(102,"PEN", 12000.00,"FILPKART"));
		repo.save(new Product(103,"PAPER", 12000.00,"FILPKART"));
		repo.save(new Product(104,"MOBILE", 12000.00,"FILPKART"));
		repo.save(new Product(105,"MOBILE", 12000.00,"FILPKART"));
		repo.save(new Product(106,"SHIRT", 12000.00,"FILPKART"));
		repo.save(new Product(107,"PANT", 12000.00,"FILPKART"));
		repo.save(new Product(108,"MOUSE", 12000.00,"FILPKART"));
		repo.save(new Product(109,"KEYBOARD", 12000.00,"FILPKART"));
		repo.save(new Product(110,"LAP", 12000.00,"FILPKART"));
		
		repo.save(new Product(111,"MOBILE", 12000.00,"FILPKART"));
		repo.save(new Product(112,"PEN", 12000.00,"FILPKART"));
		repo.save(new Product(113,"PAPER", 12000.00,"FILPKART"));
		repo.save(new Product(114,"MOBILE", 12000.00,"FILPKART"));
		repo.save(new Product(115,"MOBILE", 12000.00,"FILPKART"));
		repo.save(new Product(116,"SHIRT", 12000.00,"FILPKART"));
		repo.save(new Product(117,"PANT", 12000.00,"FILPKART"));
		repo.save(new Product(118,"MOUSE", 12000.00,"FILPKART"));
		repo.save(new Product(119,"KEYBOARD", 12000.00,"FILPKART"));
		repo.save(new Product(120,"LAP", 12000.00,"FILPKART"));
		
		repo.save(new Product(121,"MOBILE", 12000.00,"FILPKART"));
		repo.save(new Product(122,"PEN", 12000.00,"FILPKART"));
		repo.save(new Product(123,"PAPER", 12000.00,"FILPKART"));
		repo.save(new Product(124,"MOBILE", 12000.00,"FILPKART"));
		repo.save(new Product(125,"MOBILE", 12000.00,"FILPKART"));
		repo.save(new Product(126,"SHIRT", 12000.00,"FILPKART"));
		repo.save(new Product(127,"PANT", 12000.00,"FILPKART"));
		repo.save(new Product(128,"MOUSE", 12000.00,"FILPKART"));
		repo.save(new Product(129,"KEYBOARD", 12000.00,"FILPKART"));
		repo.save(new Product(130,"LAP", 12000.00,"FILPKART"));
		
		repo.save(new Product(131,"MOBILE", 12000.00,"FILPKART"));
		repo.save(new Product(132,"PEN", 12000.00,"FILPKART"));
		repo.save(new Product(133,"PAPER", 12000.00,"FILPKART"));
		repo.save(new Product(134,"MOBILE", 12000.00,"FILPKART"));
		repo.save(new Product(135,"MOBILE", 12000.00,"FILPKART"));
		repo.save(new Product(136,"SHIRT", 12000.00,"FILPKART"));
		repo.save(new Product(137,"PANT", 12000.00,"FILPKART"));
		repo.save(new Product(138,"MOUSE", 12000.00,"FILPKART"));
		repo.save(new Product(139,"KEYBOARD", 12000.00,"FILPKART"));
		repo.save(new Product(140,"LAP", 12000.00,"FILPKART"));
		
		
		//using saveAll we can insert list of data at a time(asList() comes in jdk 1.2
		//repo.saveAll(Arrays.asList(new Product(105,"MOBILE", 305.86),new Product(106,"PEN", 305.86),new Product(106,"PEN", 305.86)));
		
		//using List.of() we can insert list of data at a time(asList() comes in jdk 1.9
		//repo.List.of(Arrays.asList(new Product(105,"MOBILE", 305.86),new Product(106,"PEN", 305.86),new Product(106,"PEN", 305.86)));
		
		/************** COUNT and EXIST ************************/
		System.out.println("EXIST? :"+repo.existsById(105));
		System.out.println("ROW COUNT :"+repo.count());

		/************** BASIC FIND METHODS ************************/
		Optional<Product> opt=repo.findById(105);
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
