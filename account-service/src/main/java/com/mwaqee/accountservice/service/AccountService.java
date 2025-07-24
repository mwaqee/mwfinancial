package com.mwaqee.accountservice.service;

import com.mwaqee.accountservice.entity.Account;
import com.mwaqee.accountservice.entity.AccountType;
import com.mwaqee.accountservice.repository.AccountRepository;
import com.mwaqee.accountservice.repository.AccountTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;
    
    @Autowired
    private AccountTypeRepository accountTypeRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    public Account create(Account account) {
    	// Verify user exists first
        String url = "http://user-service:8085/api/users/" + account.getUserId() + "/exists";
        Boolean userExists = restTemplate.getForObject(url, Boolean.class);
        
        if (userExists == null || !userExists) {
            throw new RuntimeException("User does not exist");
        }
        
        // Proceed with account creation
        return repository.save(account);
    }

    public Account get(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public List<Account> getAll() {
        return repository.findAll();
    }

    public Account update(Long id, Account account) {
        Account existing = get(id);
        existing.setAccountHolderName(account.getAccountHolderName());
        existing.setUserId(account.getUserId());
        existing.setBalance(account.getBalance());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    
    public AccountType getAccountType(Long id) {
        return accountTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("AccountType not found"));
    }
}