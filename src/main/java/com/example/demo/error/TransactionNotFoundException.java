package com.example.demo.error;

public class TransactionNotFoundException extends RuntimeException{
	
	public TransactionNotFoundException(Long id) {
	    super("Could not find wallet " + id);
	  }

}
