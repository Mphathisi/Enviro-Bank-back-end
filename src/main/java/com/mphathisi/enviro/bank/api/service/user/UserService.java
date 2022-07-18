package com.mphathisi.enviro.bank.api.service.user;

import com.mphathisi.enviro.bank.api.models.User;

import java.util.List;

public interface UserService {
    User save(User user);

    User changePassword(String email, String oldPassword, String newPassword);
    public List<User> users();
    public User getUserById(int id);

    public void addRole(int userId, int roleId);
    public void linkBankAccount(int  userId, Long bankAccountId);

    public void link(String idNumber, String accountNumber);

}
