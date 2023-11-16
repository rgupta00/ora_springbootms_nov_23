package com.bankapp.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//AOP

import com.bankapp.dto.ErrorDetails;
import com.bankapp.exceptions.BankAccountNotFoundException;

@RestControllerAdvice
public class AccountAppExHandler {
	
	@ExceptionHandler(BankAccountNotFoundException.class)
	public ResponseEntity<ErrorDetails> handle404(BankAccountNotFoundException accountNotFoundException){
		ErrorDetails details=new ErrorDetails();
		details.setMessage(accountNotFoundException.getMessage());
		details.setStatusCode(HttpStatus.NOT_FOUND.toString());
		details.setToContact("rgupta.metch@gmail.com");
		details.setTimeStamp(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
	}

}
