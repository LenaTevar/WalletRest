package com.example.demo.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.model.Wallet;
/**
 * @implNote CRUD JPA for databases
 * @author hteva
 *
 */
public interface WalletRepository extends JpaRepository<Wallet, Long>, JpaSpecificationExecutor<Wallet>{
	
	public List<Wallet> findByOwnerId(long ownerId);


}
