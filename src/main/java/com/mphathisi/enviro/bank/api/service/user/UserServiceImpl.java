package com.mphathisi.enviro.bank.api.service.user;

import com.mphathisi.enviro.bank.api.models.BankAccount;
import com.mphathisi.enviro.bank.api.models.Role;
import com.mphathisi.enviro.bank.api.models.User;
import javax.transaction.Transactional;

import com.mphathisi.enviro.bank.api.repository.BankAccountRepository;
import com.mphathisi.enviro.bank.api.repository.RoleRepository;
import com.mphathisi.enviro.bank.api.repository.UserRepository;
import com.mphathisi.enviro.bank.api.service.email.EmailSender;
import com.mphathisi.enviro.bank.api.service.helpers.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired private UserRepository  userRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private PasswordGenerator passwordGenerator;

    @Override
    public User save(User user) {
        String password = passwordGenerator.generateRandomPassword();
        user.setPassword(password);
        String url = "http://localhost:4200/login";
        String message = " Hello "+ user.getName() + " your initial login details are Email : "+user.getEmail()
                + "  Password :  " + password;
        emailSender.send(user.getEmail() , message);
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public User changePassword(String email, String oldPassword, String newPassword) {


        return null;



    }

    @Override
    public List<User> users() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void addRole(int userId, int roleId) {
        User user  = userRepository.findById(userId).get();
        Role role  = roleRepository.findById(roleId).get();
        user.addRole(role);
        userRepository.save(user);
    }
    @Override
    public void linkBankAccount(int userId, Long bankAccountId) {
        User user = userRepository.findById(userId).get();
        BankAccount bankAccount = bankAccountRepository.findById(bankAccountId).get();
        user.addBankAccount(bankAccount);
        userRepository.save(user);
    }

    @Override
    public void link(String idNumber, String accountNumber) {
        User user  = userRepository.findByIdNumber(idNumber);
        BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
        userRepository.save(user);
    }

}
