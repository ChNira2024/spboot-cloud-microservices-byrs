package com.nt.niranjana.cartservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.niranjana.cartservice.model.Cart;

@RestController
@RequestMapping("/cart")
@RefreshScope
public class CartController 
{
	@Value("${my.app.title}")
	private String configdata;

	@GetMapping("/wish")
	public ResponseEntity<String> wishMessage()
	{
		return ResponseEntity.ok("WELCOME TO CART SERVICE");
	}
	
	@GetMapping("/config")
	public ResponseEntity<String> configMessage()
	{
		return ResponseEntity.ok("WELCOME TO CONFIG SERVICE DATA FROM GITHUB>>"+configdata);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable("id") Integer id)
	{
		Cart cart = new Cart();
		cart.setCartId(id);
		cart.setCartCode("OD-72619272634");
		cart.setCartCost(1200.00);
		return ResponseEntity.ok(cart);
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> addToCart(@RequestBody Cart cart)
	{
		return ResponseEntity.ok("Added To CART: "+cart);
	}
}
