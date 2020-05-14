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

import com.example.demo.model.Wallet;
import com.example.demo.repo.WalletRepository;
import com.example.demo.service.WalletService;

@RestController
public class WalletController {
	private final WalletRepository repository;
	
	@Autowired
	private WalletService wsvc;
	
	public WalletController(WalletRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/wallets")
	List<Wallet> all(){
		return wsvc.getAll();
	}
	
	@GetMapping("/wallets/owner/{ownerid}")
	List<Wallet> filterOwner(@PathVariable long ownerid){
		return wsvc.getByOwner(ownerid);
	}
	/**
	 * Tested in Postman
	 * @param newWallet Request Body in Raw Json: {"ownerId":"LONG","balance":"DOUBLE"}
	 */
	@PostMapping("/wallets")
	Wallet addWallet(@RequestBody Wallet newWallet) {		
		return wsvc.addWallet(newWallet);
	}
	
	@GetMapping("/wallet/{id}")
	Wallet one(@PathVariable Long id) {
		return wsvc.one(id);
	  }
	
	/**
	 * Test postman 1: PUT /wallet/1 Body raw Json: {"ownerId":"1","balance":"149"}
	 * Test postman 2: PUT /wallet/13 Body raw Json: {"ownerId":"1","balance":"345"}
	 * @param newWallet Request Body in Raw Json: {"ownerId":"LONG","balance":"DOUBLE"}
	 * @param id
	 */
	@PutMapping("/wallet/{id}")
	Wallet replaceWallet(@RequestBody Wallet newWallet, @PathVariable long id) {
		return wsvc.replaceWallet(newWallet, id);
	}
	
	@DeleteMapping("/wallet/{id}")
	void deleteWallet(@PathVariable long id) {
		wsvc.deleteWallet(id);
	}
}
