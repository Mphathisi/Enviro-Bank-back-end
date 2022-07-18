package com.mphathisi.enviro.bank.api.service.bankAccount;


import com.mphathisi.enviro.bank.api.models.BankAccount;
import com.mphathisi.enviro.bank.api.models.constants.AccountType;

import java.math.BigDecimal;
import java.util.List;
import java.util.zip.DataFormatException;

public interface BankAcountService {
    public BankAccount create(BankAccount bankAccount);

    public List<BankAccount> bankAccounts();

    public BankAccount getAccountById(Long id);

    public void adminDeposit(String accountNumber, BigDecimal depositAmount);


    void deposit(String senderAccountNo ,String receiverAccountNO, BigDecimal amount);
    void transferTo(String sederAccountNo, String receiverAccountNo, BigDecimal amount, String from , String to);

}