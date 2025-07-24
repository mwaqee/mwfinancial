package com.mwaqee.accountservice.controller;

import com.mwaqee.accountservice.dtos.AccountRequestDto;
import com.mwaqee.accountservice.entity.Account;
import com.mwaqee.accountservice.entity.AccountType;
import com.mwaqee.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody AccountRequestDto accountRequestDto) {
        
    	AccountType type = service.getAccountType(accountRequestDto.getAccountTypeId());    	        

	    Account account = new Account();
	    account.setAccountHolderName(accountRequestDto.getAccountHolderName());
	    account.setUserId(accountRequestDto.getUserId());
	    account.setBalance(accountRequestDto.getBalance());
	    account.setAccountStatus(accountRequestDto.getAccountStatus());
	    account.setAccountType(type);
    	
    	Account savedAccount = service.create(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAccount);
    }

    @GetMapping
    public List<Account> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public Account update(@PathVariable Long id, @RequestBody Account account) {
        return service.update(id, account);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}