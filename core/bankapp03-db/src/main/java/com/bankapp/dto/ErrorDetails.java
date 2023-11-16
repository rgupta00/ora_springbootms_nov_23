package com.bankapp.dto;

import java.time.LocalDateTime;

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
public class ErrorDetails {
	private String message;
	private String statusCode;
	private String toContact;
	private LocalDateTime timeStamp;
	
}
