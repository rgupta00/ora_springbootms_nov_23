package com.shippingapp.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	private int id;
	private double totalPrice;
	private Date orderDate;
	private Customer customer;
	private Product product;

}