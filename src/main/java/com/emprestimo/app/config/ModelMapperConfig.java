package com.emprestimo.app.config;

import com.emprestimo.app.dto.cliente.PessoaDto;
import com.emprestimo.app.model.cliente.Pessoa;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }



}
