package com.mphathisi.enviro.bank.api.service.email;

public interface EmailSender {
    void send(String to, String email);
    void paymentNotification(String to, String message);
    void messageAdmin(String from, String message);
}
