package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Transaction;
import com.example.demo.model.Wallet;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	public List<Transaction> findBywalletId(long walletId);
}
