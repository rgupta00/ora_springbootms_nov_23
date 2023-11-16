package com.bankapp.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "account_table")
public class Account {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//@NotBlank
	@NotNull(message = "{account.name.absent}")
	private String name;
	
	private Double balance;
	
	public Account(String name, Double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}
	
	
	
}