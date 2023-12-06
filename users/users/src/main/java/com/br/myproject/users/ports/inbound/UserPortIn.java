package com.br.myproject.users.ports.inbound;

import com.br.myproject.users.application.dto.CreateUserDTO;
import com.br.myproject.users.application.dto.UserDTO;
import com.br.myproject.users.domain.entity.User;

import java.util.Optional;

public interface UserPortIn {

    public UserDTO createUser(CreateUserDTO createUserDTO) throws Exception;

    void deleteUser(Long id);

    UserDTO findUser(Long id);

    Optional<String> login(String email, String password);

    User findUserByEmail(String email);

    User findById(Long id);
}
