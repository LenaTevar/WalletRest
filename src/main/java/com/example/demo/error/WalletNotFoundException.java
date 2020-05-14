package com.example.demo.error;


public class WalletNotFoundException extends RuntimeException {

	public WalletNotFoundException(Long id) {
	    super("Could not find wallet " + id);
	  }
}