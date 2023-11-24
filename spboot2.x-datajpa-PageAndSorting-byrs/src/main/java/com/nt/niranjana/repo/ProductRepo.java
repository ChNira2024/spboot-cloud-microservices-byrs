package com.nt.niranjana.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.niranjana.entity.Product;

public interface ProductRepo extends PagingAndSortingRepository<Product,Integer>{

}
