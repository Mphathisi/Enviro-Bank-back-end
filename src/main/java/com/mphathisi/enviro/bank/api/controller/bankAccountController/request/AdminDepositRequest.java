package com.mphathisi.enviro.bank.api.controller.bankAccountController.request;

import java.math.BigDecimal;

public class AdminDepositRequest {
    private String accountNumber;
    private BigDecimal depositAmount;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }
}
