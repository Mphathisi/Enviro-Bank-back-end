package com.mphathisi.enviro.bank.api.controller.userController.request;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BankRequest {
    String idNumber;
    String accountNumber;
}
