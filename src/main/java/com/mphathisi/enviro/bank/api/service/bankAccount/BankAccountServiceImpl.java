package com.mphathisi.enviro.bank.api.service.bankAccount;

import com.mphathisi.enviro.bank.api.models.BankAccount;
import com.mphathisi.enviro.bank.api.models.User;
import com.mphathisi.enviro.bank.api.models.constants.AccountStatus;
import com.mphathisi.enviro.bank.api.models.constants.AccountType;
import com.mphathisi.enviro.bank.api.repository.BankAccountRepository;
import com.mphathisi.enviro.bank.api.service.helpers.AccountNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;


@Service
public class BankAccountServiceImpl implements BankAcountService{
    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountNumberGenerator accountNumberGenerator;



    @Override
    public BankAccount create(BankAccount bankAccount)  {


        BigDecimal zero = new BigDecimal(0);
        if(bankAccount.getAvailableBalance()== null){
            bankAccount.setAvailableBalance(zero);
            bankAccount.setAccountStatus(AccountStatus.PENDING);
        }

        else{
            bankAccount.setAccountStatus(AccountStatus.ACTIVE);
            System.out.println("Account activated");
        }

        bankAccount.setCreatedDate(new Date());
        bankAccount.setLastUpdatedDate(new Date());

        bankAccount.setLatestBalance(bankAccount.getAvailableBalance());

        //String accountNumber = accountNumberGenerator.accountNumber();
        //bankAccount.setAccountNumber(accountNumber);

        return bankAccountRepository.save(bankAccount);
    }


    @Override
    public List<BankAccount> bankAccounts() {
        List<BankAccount> bankAccountList = new ArrayList<>();
        bankAccountRepository.findAll().forEach(bankAccountList::add);
        return bankAccountList;
    }

    @Override
    public BankAccount getAccountById(Long id) {
        return bankAccountRepository.findById(id).get();
    }

    @Override
    public void adminDeposit(String accountNumber, BigDecimal depositAmount) {

        System.out.println("accountNumber: " + accountNumber);
        System.out.println("depositAmount: " + depositAmount);
        BankAccount receiverAccount = bankAccountRepository.findByAccountNumber(accountNumber);

        System.out.println("receiverAccount: " + receiverAccount.getAccountNumber());


    }


    @Override
    public void deposit(String senderAccountNo, String receiverAccountNo, BigDecimal amount) {
        //sending  between accounts

        try {
            BankAccount sender = bankAccountRepository.findByAccountNumber(senderAccountNo);
            BankAccount receiver = bankAccountRepository.findByAccountNumber(receiverAccountNo);

            if (sender != null && receiver != null) {
                if (sender.getAvailableBalance().compareTo(amount) >= 0) {
                    sender.setAvailableBalance(sender.getAvailableBalance().subtract(amount));
                    sender.setLatestBalance(sender.getAvailableBalance());
                    sender.setLastUpdatedDate(new Date());
                    bankAccountRepository.save(sender);

                    receiver.setAvailableBalance(receiver.getAvailableBalance().add(amount));
                    receiver.setLatestBalance(receiver.getAvailableBalance());
                    receiver.setLastUpdatedDate(new Date());
                    bankAccountRepository.save(receiver);
                } else {
                    System.out.println("Insufficient balance");
                }
            } else {
                System.out.println("Account does not exist");
            }
        } catch (Exception e) {
            System.out.println("Account does not exist");
        }

    }









    @Override
    public void transferTo(String sederAccountNo, String receiverAccountNo, BigDecimal amount, String from ,String to) {
        if(from.equals(AccountType.SAVINGS.toString()) && to.equals(AccountType.CREDIT.toString())){
            BankAccount sender = bankAccountRepository.findByAccountNumber(sederAccountNo);
            BankAccount receiver = bankAccountRepository.findByAccountNumber(receiverAccountNo);
            System.out.println("Sender available balance:"+sender.getAvailableBalance());
            System.out.println("Receiver balance:"+receiver.getAvailableBalance());

            BigDecimal senderAmount = sender.getAvailableBalance().subtract(amount);
            sender.setAvailableBalance(senderAmount);
            System.out.println("Sender left with:" + sender.getAvailableBalance());
            BigDecimal receiverAmount = receiver.getAvailableBalance().add(amount);

            Date date = new  Date();
            Long time =  date.getTime();
            System.out.println(time);
            receiver.setAvailableBalance(receiverAmount);
            receiver.setLatestBalance(receiverAmount);
            System.out.println("Receiver have " + receiver.getAvailableBalance());
            bankAccountRepository.save(sender);
            bankAccountRepository.save(receiver);
        }
        else {
            System.out.println("wrong selection");
        }

    }


}