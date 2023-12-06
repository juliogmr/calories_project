package com.br.myproject.users.application.dto;

import lombok.Data;

@Data
public class CreateUserDTO {
    private String fullName;
    private String email;
    private String password;
    private String cpf;
}
