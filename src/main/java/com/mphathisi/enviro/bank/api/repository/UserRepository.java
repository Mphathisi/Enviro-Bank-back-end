package com.mphathisi.enviro.bank.api.repository;

import com.mphathisi.enviro.bank.api.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    User findByIdNumber(String idNumber);
}