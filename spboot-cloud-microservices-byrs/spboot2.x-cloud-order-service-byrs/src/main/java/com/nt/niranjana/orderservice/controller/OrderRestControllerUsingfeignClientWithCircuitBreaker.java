//package com.nt.niranjana.orderservice.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.nt.niranjana.orderservice.consumer.CartServiceConsumerUsingFeignClientWithCircuitBreaker;
//import com.nt.niranjana.orderservice.feignfallback.FeignClintFallback;
//import com.nt.niranjana.orderservice.model.Cart;
//
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//
//@RestController
//@RequestMapping("/order")
//@RefreshScope
//public class OrderRestControllerUsingfeignClientWithCircuitBreaker 
//{
//	@Autowired
//	private CartServiceConsumerUsingFeignClientWithCircuitBreaker falback;
//	
//	@GetMapping("/place")
//	public ResponseEntity<String> placeOrder()
//	{
//		//response from cart service
//		String cartResp = falback.wishMessage().getBody();
//		return ResponseEntity.ok("ORDER PLACED WITH =>"+cartResp);
//	}
//	
//	@GetMapping("/config")
//	//@CircuitBreaker(name="fetchBookOrderBreaker",fallbackMethod = "fetchBookOrderFallbackMethodCircuitBreaker")
//	public ResponseEntity<String> dataFromCartConfig()
//	{
//		//response from cart service
//		String cartResp = falback.configMessage().getBody();
//		return ResponseEntity.ok("ORDER MESSAGE =>"+cartResp);
//	}
//	//Creating fall back method for CircuirBreaker(CREATING FALL BACK METHOD FOR CIRCUITBREAKER)
//		public Cart fetchBookOrderFallbackMethodCircuitBreaker(Exception ex)
//		{
//			//logger.info("Fallback is excuted because fetchBookOrderFallbackMethod service is down: "+ex.getMessage());
//			System.out.println("Fallback is excuted because fetchBookOrderFallbackMethod service is down: "+ex.getMessage());
//			Cart cart = new Cart();
//			cart.setCartId(0000);
//			cart.setCartCode("unable to fetch book details,service down");
//			cart.setCartCost(null);
//			return cart;
//		}
//	@PostMapping("/fetch/{id}")
//	public ResponseEntity<String> fetchOrderWithCart(@PathVariable("id") Integer id)
//	{
//		//response from cart service
//		Cart cob = falback.getCartById(id).getBody();
//		return ResponseEntity.ok("ORDER WITH CART DATA =>"+cob);
//	}
//	
//	@PostMapping("/addToCart")
//	public ResponseEntity<String> addToCart(@RequestBody Cart cart)
//	{
//		//response from cart service
//		String cartResp = falback.addToCart(cart).getBody();
//		return ResponseEntity.ok("ORDER WITH =>"+cartResp);
//	}
//
//}
