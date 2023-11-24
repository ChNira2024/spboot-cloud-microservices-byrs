//package com.nt.niranjana.orderservice.feignfallback;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//
//import com.nt.niranjana.orderservice.consumer.CartServiceConsumerUsingFeignClientWithCircuitBreaker;
//import com.nt.niranjana.orderservice.model.Cart;
//
//@Component
//public class FeignClintFallback implements CartServiceConsumerUsingFeignClientWithCircuitBreaker 
//{
//
//	@Override
//	public ResponseEntity<String> wishMessage() 
//	{
//		Cart user = Cart.builder()
//                .cartId(00000)
//                .cartCode("This user is created dummy because some service is down")
//                .cartCost(null)
//                .build();
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<String> configMessage() 
//	{
//		Cart user = Cart.builder()
//                .cartId(00000)
//                .cartCode("This user is created dummy because some service is down")
//                .cartCost(null)
//                .build();
//		return ResponseEntity.ok("NO ORDER PLACED WITH =>");
//	}
//
//	@Override
//	public ResponseEntity<Cart> getCartById(Integer id)
//	{
//		Cart cart = Cart.builder()
//                .cartId(00000)
//                .cartCode("This user is created dummy because some service is down")
//                .cartCost(null)
//                .build();
//		return new ResponseEntity<Cart>(cart,HttpStatus.OK);	
//	}
//
//	@Override
//	public ResponseEntity<String> addToCart(Cart cart) 
//	{
//		Cart user = Cart.builder()
//                .cartId(00000)
//                .cartCode("This user is created dummy because some service is down")
//                .cartCost(null)
//                .build();
//		return ResponseEntity.ok("NO ORDER PLACED WITH =>");
//	}
//
//}
