package com.bankapp.controller;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handle500(Exception exception){
		ErrorDetails details=new ErrorDetails();
		details.setMessage("pls try afer some time server is down");
		details.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		details.setToContact("rgupta.metch@gmail.com");
		details.setTimeStamp(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
	}
	
	//MethodArgumentNotValidException
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> handle400(MethodArgumentNotValidException ex){
		ErrorDetails details=new ErrorDetails();
		
		String message= ex.getBindingResult().getAllErrors()
				.stream()
				.map(x->x.getDefaultMessage())
				.collect(Collectors.joining(" ,"));
		
		
		details.setMessage(message);
		
		details.setStatusCode(HttpStatus.BAD_REQUEST.toString());
		details.setToContact("rgupta.metch@gmail.com");
		details.setTimeStamp(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
	}

}
