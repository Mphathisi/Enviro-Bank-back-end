package com.mphathisi.enviro.bank.api.models;


import com.mphathisi.enviro.bank.api.models.constants.AccountStatus;
import com.mphathisi.enviro.bank.api.models.constants.AccountType;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "bankAccounts")
public class BankAccount {
    @Id
    @GeneratedValue
    @Column(name = "bank_account_id", updatable = false, nullable = false)
    Long bank_account_id;


    String accountNumber;


    @Enumerated(EnumType.STRING)
    private AccountType accountType;


    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;


    BigDecimal availableBalance;


    BigDecimal latestBalance;
    private Date createdDate;
    private Date lastUpdatedDate;

    public void setCreatedDate(Date date) {
        this.createdDate = date;
    }

    public void setLastUpdatedDate(Date date) {
        this.lastUpdatedDate = date;

    }

}