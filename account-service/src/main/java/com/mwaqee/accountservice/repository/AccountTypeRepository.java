package com.mwaqee.accountservice.repository;

import com.mwaqee.accountservice.entity.AccountType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {
}