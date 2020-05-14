package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Transaction {
	private @Id @GeneratedValue long id;
	private long walletId;
	private String type;
	private double amount;
	
	Transaction(){}
	public Transaction (long walletId, String type, double amount) {
		this.walletId = walletId;
		this.type = type;
		this.amount = amount;
	}
}
