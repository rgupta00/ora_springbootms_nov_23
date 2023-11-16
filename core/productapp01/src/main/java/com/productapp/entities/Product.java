package com.productapp.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "product_table")
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer id;
	
	@NotNull(message = "{product.name.absent}")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{product.name.invalid}")
	
	@Column(name = "product_name")
	private String name;
	
	@NotNull(message = "{product.price.absent}")
	@Range(min = 100, max = 190000, message = "{product.price.invalid}")
	
	@Column(name = "product_price")
	private BigDecimal price;
	
	public Product(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
	
	
	
}















