package com.mwaqee.accountservice.dtos;

import java.math.BigDecimal;

import com.mwaqee.accountservice.enums.AccountStatus;

import lombok.Data;

@Data
public class AccountRequestDto {
    private String accountHolderName;
    private Long userId;
    private BigDecimal balance;
    private Long accountTypeId; // Accept primitive ID here
    private AccountStatus accountStatus;
}
