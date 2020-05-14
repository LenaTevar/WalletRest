package com.example.demo;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Wallet;
import com.example.demo.repo.WalletRepository;

@Configuration
@Slf4j
class LoadDatabase {
  @Bean
  CommandLineRunner initDatabase(WalletRepository repository) {
    return args -> {
    	if (repository.findAll().isEmpty()) {
    		System.out.println("Loading Data for first time.");
    		log.info("Preloading " + repository.save(new Wallet(1,100)));
    		log.info("Preloading " + repository.save(new Wallet(2, 200)));
    	} else {
    		System.out.println("Database in persistence mode. Not loading new data.");
    	}
    		
    };
  }
}
