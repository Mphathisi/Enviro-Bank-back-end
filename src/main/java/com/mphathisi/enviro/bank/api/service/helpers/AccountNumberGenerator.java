package com.mphathisi.enviro.bank.api.service.helpers;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccountNumberGenerator {

    public String accountNumber(){

        Random random = new Random();
        String start  = "1234";
        int value = random.nextInt(10);
        start += Integer.toString(value);

        int count = 0;
        int n = 0;

        for (int i = 0; i < 3; i++) {
            if(count == 4){
                start +="";
                count = 0;
            }
            else {
                n = random.nextInt(10);
                start += Integer.toString(n);
                count++;
            }
        }
        return start;

    }

    public String generateAccountNumber(String accountNumberPrefix) {
        return accountNumberPrefix + accountNumber();
    }
}
