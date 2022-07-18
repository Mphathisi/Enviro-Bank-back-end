package com.mphathisi.enviro.bank.api.controller.userController;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.mphathisi.enviro.bank.api.controller.userController.request.BankRequest;
import com.mphathisi.enviro.bank.api.controller.userController.request.RoleRequest;
import com.mphathisi.enviro.bank.api.models.Role;
import com.mphathisi.enviro.bank.api.models.User;
import com.mphathisi.enviro.bank.api.service.role.RoleService;
import com.mphathisi.enviro.bank.api.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserApi {

    @Autowired private UserService service;
    @Autowired private RoleService roleService;

    @PutMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody @Valid User user) {
        User createdUser = service.save(user);
        URI uri = URI.create("/register/" + createdUser.getId());

        UserDTO userDto = new UserDTO(createdUser.getId(), createdUser.getEmail() , createdUser.getName(), createdUser.getSurname(),
                createdUser.getIdNumber());
        return ResponseEntity.created(uri).body(userDto);
    }
    @PutMapping("/changePassword")
    public ResponseEntity<?>changePassword(@RequestBody String email, String oldPassword, String newPassword) {
        User user = service.changePassword(email, oldPassword, newPassword);

        return ResponseEntity.ok(user);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> userList = service.users();
        return new ResponseEntity<>(userList , HttpStatus.OK);
    }

    @GetMapping({"/users/{userId}"})
    public ResponseEntity<User> getUser(@PathVariable int userId) {
        return new ResponseEntity<>(service.getUserById(userId), HttpStatus.OK);
    }

    @PostMapping("/createRole")
    public void createRole(@RequestBody Role role) {
        Role createRole = roleService.createRole(role);
    }

    @PutMapping("/addRole")
    public void addUserRole(@RequestBody RoleRequest roleRequest){
        service.addRole(roleRequest.getUserId(), roleRequest.getRoleId());
    }

    @PostMapping("/link")
    public void link(@RequestBody BankRequest bankRequestt) {
        service.link(bankRequestt.getIdNumber(), bankRequestt.getAccountNumber());
    }
}
