package com.br.myproject.users.infraestructure.configuration.handlers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Utils {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
