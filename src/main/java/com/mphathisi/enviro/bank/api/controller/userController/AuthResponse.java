package com.mphathisi.enviro.bank.api.controller.userController;

import com.mphathisi.enviro.bank.api.models.Role;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String email;
    private String accessToken;
    private String name;
    private String surname;
    private String idNumber;
    List<String> roles = new ArrayList<>();
}
