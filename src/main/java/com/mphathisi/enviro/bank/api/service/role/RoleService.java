package com.mphathisi.enviro.bank.api.service.role;

import com.mphathisi.enviro.bank.api.models.Role;
import com.mphathisi.enviro.bank.api.models.User;
import com.mphathisi.enviro.bank.api.repository.RoleRepository;
import com.mphathisi.enviro.bank.api.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    public Role createRole(Role role) {
        roleRepository.save(role);
        return role;
    }


}

