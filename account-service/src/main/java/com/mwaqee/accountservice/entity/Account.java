package com.mwaqee.accountservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

import com.mwaqee.accountservice.enums.AccountStatus;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String accountHolderName;
    private Long userId;
    private BigDecimal balance;
    
    @ManyToOne
    @JoinColumn(name = "account_type", referencedColumnName = "id")
    private AccountType accountType;
    
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
}