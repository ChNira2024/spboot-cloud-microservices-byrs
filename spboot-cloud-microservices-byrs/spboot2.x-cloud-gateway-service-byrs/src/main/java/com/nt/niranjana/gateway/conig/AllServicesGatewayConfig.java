//package com.nt.niranjana.gateway.conig;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AllServicesGatewayConfig 
//{
//	@Bean
//	public RouteLocator myOwnConfigRoutes(RouteLocatorBuilder builder)
//	{
//		return builder.routes()
//				.route("cart-service",r->r.path("/cart/**").uri("lb://CART-SERVICE"))
//				.route("order-service",r->r.path("/order/**").uri("lb://ORDER-SERVICE"))
//				.build();
//	}
//
//}
////using lb://CART-SERVICE for mutliple instnace.because if u have multiple instance then it will fetch the lowest LB(load balancer)..
////otherwise u can use like this http://172.10.12.35:900 if u have only one instance.
//Two way to configure using @Configuration or application.yml

