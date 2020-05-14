package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.error.BalanceNotEnoughException;
import com.example.demo.error.TransactionNotFoundException;
import com.example.demo.error.WalletNotFoundException;
import com.example.demo.model.TransType;
import com.example.demo.model.Transaction;
import com.example.demo.model.Wallet;
import com.example.demo.repo.TransactionRepository;
import com.example.demo.repo.WalletRepository;

/**
 * Service used in Wallet Controller for transaction management.
 * @author hteva
 *
 */
@Validated
@Service
public class TransactionService {
	@Autowired
	private WalletRepository walletRepo;
	@Autowired
	private TransactionRepository transRepo;
	@Autowired
	private WalletService walletSvc;

	public List<Transaction> allTransactions(){
		return transRepo.findAll();
	}
	
	public List<Transaction> transactionsByUser(long ownerid){	
		
		List<Transaction> result = new ArrayList<Transaction>();
		List<Wallet> wallets = walletSvc.getByOwner(ownerid);
		for (Wallet wallet : wallets) {
			List <Transaction> transactions = transRepo.findBywalletId(wallet.getId());
			result.addAll(transactions);
		}
		return result;
	}
	
	/**
	 * Finds the wallet and proceeds to the transaction. 
	 * @throws WalletNotFoundException if the wallet id does not match
	 * @throws BalanceNotEnoughException if the wallet has not enough balance for the transaction
	 */
	public Transaction addTransaction(Transaction n_transaction) throws WalletNotFoundException, BalanceNotEnoughException {
			Wallet wallet = walletSvc.one(n_transaction.getWalletId());
			return this.addTransactionByType(n_transaction, wallet);		
	}
	
	private Transaction addTransactionByType(Transaction n_transaction, Wallet wallet) throws BalanceNotEnoughException {
		Wallet currentWallet = null;
		if (TransType.CREDIT.isEquals(n_transaction.getType())) {
			currentWallet = this.updateWalletCredit(n_transaction, wallet);
		} else {
			currentWallet = this.updateWalletDebit(n_transaction, wallet);
		}
		 
		walletSvc.replaceWallet(currentWallet, wallet.getId());
		return transRepo.save(n_transaction);
	}
	/**
	 * Used in method addTransactionByType when Transaction Type is Credit. 
	 * @return wallet updated 
	 */	
	private Wallet updateWalletCredit(Transaction n_transaction, Wallet wallet) {
		wallet.setBalance(wallet.getBalance() + n_transaction.getAmount());
		return wallet;
	}
	/**
	 * Used in method addTransactionByType when Transaction Type is Debt. 
	 * @return wallet updated
	 * @throws Not Enough Balance When the wallet has not enough coins(?) for the payment.  
	 */
	private Wallet updateWalletDebit(Transaction n_transaction, Wallet wallet) throws BalanceNotEnoughException {
		double updatedBalance = wallet.getBalance() - n_transaction.getAmount();
		
		if (updatedBalance >= 0) {
			wallet.setBalance(updatedBalance);	
		} else {
			throw new BalanceNotEnoughException(n_transaction.getId());
		}
		
		return wallet;
	}
	
	
	public Transaction getTransaction(long id) {
	    return transRepo.findById(id)
	      .orElseThrow(() -> new TransactionNotFoundException(id));
	  }
	
	public Transaction replaceTransaction(Transaction n_transaction, long id) {
		return transRepo.findById(id).map(t ->{
			t.setAmount(n_transaction.getAmount());
			t.setType(n_transaction.getType());
			t.setWalletId(n_transaction.getWalletId());
			return transRepo.save(t);
		}).orElseGet(() -> {
			n_transaction.setId(id);
			return this.addTransaction(n_transaction);
		});
		
	}
	
	public void deleteTransaction( long id) {
		transRepo.deleteById(id);
	}
}
