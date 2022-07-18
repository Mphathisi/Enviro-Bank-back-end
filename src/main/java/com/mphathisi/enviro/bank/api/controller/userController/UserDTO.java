package com.mphathisi.enviro.bank.api.controller.userController;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Integer id;
    private String email;
    private String name;
    private String surname;
    private String idNumber;

}
