//package com.nt.niranjana.orderservice.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.nt.niranjana.consumer.CartServiceConsumerUsingDiscoveryClient;
//
//@RestController
//@RequestMapping("/order")
//public class OrderRestControllerUsingDiscoveryClient 
//{
//	@Autowired
//	private CartServiceConsumerUsingDiscoveryClient consumer;
//	
//	@GetMapping("/place")
//	public ResponseEntity<String> placeOrder()
//	{
//		//response from cart service
//		String cartResp = consumer.getCartResponse();
//		return ResponseEntity.ok("ORDER PLACED WITH =>"+cartResp);
//	}
//
//}


