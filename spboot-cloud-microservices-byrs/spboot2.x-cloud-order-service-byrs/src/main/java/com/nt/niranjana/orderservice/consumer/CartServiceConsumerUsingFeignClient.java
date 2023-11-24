package com.nt.niranjana.orderservice.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nt.niranjana.orderservice.model.Cart;


@FeignClient("CART-SERVICE")
public interface CartServiceConsumerUsingFeignClient 
{
	
	@GetMapping("/cart/wish")
	public ResponseEntity<String> wishMessage();
	
	@GetMapping("/cart/config")
	public ResponseEntity<String> configMessage();
	
	@GetMapping("/cart/find/{id}")
	public ResponseEntity<com.nt.niranjana.orderservice.model.Cart> getCartById(@PathVariable("id") Integer id);
	
	@PostMapping("/cart/create")
	public ResponseEntity<String> addToCart(@RequestBody Cart cart);
	
}
