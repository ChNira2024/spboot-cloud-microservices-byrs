package com.nt.niranjana.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.niranjana.orderservice.consumer.CartServiceConsumerUsingFeignClient;
import com.nt.niranjana.orderservice.model.Cart;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderRestControllerUsingfeignClient 
{
	@Autowired
	private CartServiceConsumerUsingFeignClient consumer;
	
	@GetMapping("/place")
	public ResponseEntity<String> placeOrder()
	{
		//response from cart service
		String cartResp = consumer.wishMessage().getBody();
		return ResponseEntity.ok("ORDER PLACED WITH =>"+cartResp);
	}
	
	@GetMapping("/config")
	public ResponseEntity<String> dataFromCartConfig()
	{
		//response from cart service
		String cartResp = consumer.configMessage().getBody();
		return ResponseEntity.ok("ORDER MESSAGE =>"+cartResp);
	}
	
	@PostMapping("/fetch/{id}")
	public ResponseEntity<String> fetchOrderWithCart(@PathVariable("id") Integer id)
	{
		//response from cart service
		Cart cob = consumer.getCartById(id).getBody();
		return ResponseEntity.ok("ORDER WITH CART DATA =>"+cob);
	}
	
	@PostMapping("/addToCart")
	public ResponseEntity<String> addToCart(@RequestBody Cart cart)
	{
		//response from cart service
		String cartResp = consumer.addToCart(cart).getBody();
		return ResponseEntity.ok("ORDER WITH =>"+cartResp);
	}

}
