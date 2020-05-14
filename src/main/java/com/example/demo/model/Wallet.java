package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"id"})})
public class Wallet {
	private @Id @GeneratedValue long id;
	private long ownerId;
	private double balance;
	
	Wallet (){}
	public Wallet(long ownerId, double balance){
		this.ownerId = ownerId;
		
		this.balance = balance;
	}
	

}
