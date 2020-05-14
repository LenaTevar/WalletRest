package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.TransactionNotFoundException;
import com.example.demo.model.Transaction;
import com.example.demo.repo.TransactionRepository;
import com.example.demo.service.TransactionService;
import com.example.demo.service.WalletService;;
@RestController
public class TransactionController {

	private final TransactionRepository repository;
	
	@Autowired
	private TransactionService transSvc;
	
	
	public TransactionController(TransactionRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/transactions")
	List<Transaction> allTransactions(){
		return transSvc.allTransactions();
	}
	/**
	 * Example Body raw Json: {"walletId": "8", "type": "D", "amount":"1"}
	 * @param n_transaction
	 * @return
	 */
	@PostMapping("/transactions")
	Transaction addTransaction(@RequestBody Transaction n_transaction) {
		return transSvc.addTransaction(n_transaction);
	}
	
	@GetMapping("/transactions/{id}")
	Transaction getTransaction(@PathVariable Long id) {

		return transSvc.getTransaction(id);
	  }
	
	@GetMapping("/transactions/user/{ownerid}")
	List<Transaction> transactionsByUser(@PathVariable long ownerid){
		return transSvc.transactionsByUser(ownerid);
	}
	
	@PutMapping("/transactions/{id}")
	Transaction replaceTransaction(@RequestBody Transaction n_transaction, @PathVariable long id) {
		return transSvc.replaceTransaction(n_transaction, id);
	}
	
	@DeleteMapping("/transactions/{id}")
		void deleteTransaction(@PathVariable long id) {
		transSvc.deleteTransaction(id);
	}
}

