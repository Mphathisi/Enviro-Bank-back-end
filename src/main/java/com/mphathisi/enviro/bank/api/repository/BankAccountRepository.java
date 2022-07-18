package com.mphathisi.enviro.bank.api.repository;

import com.mphathisi.enviro.bank.api.models.BankAccount;
import com.mphathisi.enviro.bank.api.models.constants.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {
    BankAccount findByAccountNumber(String accountNumber);

    BankAccount findByAccountType(AccountType accountType);
}
