package com.example.demo.error;

public class BalanceNotEnoughException extends RuntimeException{
	public BalanceNotEnoughException(long id) {
		super("The Wallet has no coin, transaction: " + id + "  failed.");
	}
}
