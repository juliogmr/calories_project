package com.br.myproject.users.domain.service;

import com.br.myproject.users.application.dto.CreateUserDTO;
import com.br.myproject.users.application.dto.UserDTO;
import com.br.myproject.users.domain.entity.Role;
import com.br.myproject.users.domain.entity.User;
import com.br.myproject.users.infraestructure.configuration.handlers.JwtUtils;
import com.br.myproject.users.infraestructure.configuration.handlers.PasswordUtils;
import com.br.myproject.users.infraestructure.persistence.UserRepository;
import com.br.myproject.users.ports.inbound.UserPortIn;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAdapterIn implements UserPortIn {

    private final UserRepository userRepository;

    private final ModelMapper mapper;
    @Override
    public UserDTO createUser(CreateUserDTO createUserDTO) throws Exception {
        if(findUserByEmail(createUserDTO.getEmail()) != null) {
            User user = new User();
            user.setFullName(createUserDTO.getFullName());
            user.setEmail(createUserDTO.getEmail());
            user.setPassword(PasswordUtils.hashPassword(createUserDTO.getPassword()));
            user.setCpf(createUserDTO.getCpf());
            user.setRole(Role.CLIENTE);
            User savedUser = userRepository.save(user);
            return mapper.map(savedUser, UserDTO.class);
        } else {
            throw new Exception("Usuário já existe!");
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(findById(id));
    }

    @Override
    public UserDTO findUser(Long id) {
        User user = findById(id);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFullName(user.getFullName());
        userDTO.setEmail(user.getEmail());
        userDTO.setCpf(user.getCpf());
        return userDTO;
    }

    @Override
    public Optional<String> login(String email, String password) {
        User user = findUserByEmail(email);
        if (user != null && PasswordUtils.matchPassword(password, user.getPassword())) {
            String token = JwtUtils.generateToken(user);
            return Optional.of(token);
        }
        return Optional.empty();
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(entity -> mapper.map(entity, User.class))
                .orElse(null);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .map(entity -> mapper.map(entity, User.class))
                .orElse(null);
    }
}
