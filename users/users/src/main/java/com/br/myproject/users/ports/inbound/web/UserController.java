package com.br.myproject.users.ports.inbound.web;

import com.br.myproject.users.application.dto.CreateUserDTO;
import com.br.myproject.users.application.dto.LoginDTO;
import com.br.myproject.users.application.dto.UserDTO;
import com.br.myproject.users.ports.inbound.UserPortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Validated
public class UserController {

    private final UserPortIn userPortIn;

    @PostMapping("/fazer-login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        Optional<String> token = userPortIn.login(loginDTO.getEmail(), loginDTO.getPassword());
        return token.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO createUserDTO) throws Exception {
        return new ResponseEntity<>(userPortIn.createUser(createUserDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){
        userPortIn.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
