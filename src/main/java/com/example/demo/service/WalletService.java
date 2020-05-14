package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.error.WalletNotFoundException;
import com.example.demo.model.Wallet;
import com.example.demo.repo.WalletRepository;
/**
 * Wallet service used in Wallet Controller and Transaction Service 
 * to manage wallets and its contents. 
 *
 */
@Validated
@Service
public class WalletService {
	@Autowired
	private WalletRepository repository;
	
	public List<Wallet> getAll(){
		return repository.findAll();
	}

	public Wallet addWallet(Wallet newWallet) {
		return repository.save(newWallet);
	}
	
	public Wallet one(Long id) {
	    return repository.findById(id)
	      .orElseThrow(() -> new WalletNotFoundException(id));
	  }
	
	public Wallet replaceWallet( Wallet newWallet,  long id) {
		return repository.findById(id).map(wallet ->{
			wallet.setOwnerId(newWallet.getOwnerId());
			wallet.setBalance(newWallet.getBalance());
			return repository.save(wallet);
		}).orElseGet(() -> {
			newWallet.setId(id);
			return repository.save(newWallet);
		});
	}
	
	public 	void deleteWallet( long id) {
		repository.deleteById(id);
	}
	
	public List<Wallet> getByOwner(long ownerid){
		List<Wallet> filtered = repository.findByOwnerId(ownerid);
		if (filtered.isEmpty()) {
			throw new WalletNotFoundException(ownerid);
		}
		return filtered;
	}	
}
