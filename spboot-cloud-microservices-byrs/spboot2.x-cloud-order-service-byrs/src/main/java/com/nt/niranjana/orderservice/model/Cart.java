package com.nt.niranjana.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cart 
{
	private Integer cartId;
	private String cartCode;
	private Double cartCost;
}
