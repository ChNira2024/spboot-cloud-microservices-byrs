//package com.nt.niranjana.orderservice.consumer;
//
//import java.net.URI;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//@Component
//public class CartServiceConsumerUsingLoadBalancerClient 
//{
//	@Autowired
//	private LoadBalancerClient client;
//	
//	public String getCartResponse()
//	{
//		//get serviceID from Eureka Server
//		ServiceInstance si = client.choose("CART-SERVICE");
//		
//		//read URI
//		URI uri = si.getUri();
//		
//		//add path ===>returns URL
//		String url = uri + "/cart/wish";
//		System.out.println("URL is "+url);
//		
//		//use RestTempalte and call
//		RestTemplate rt = new RestTemplate();
//		
//		//make HTTP request and get response
//		ResponseEntity<String> response = rt.getForEntity(url, String.class);
//		
//		//return response body
//		return response.getBody();
//		
//	}
//
//}


