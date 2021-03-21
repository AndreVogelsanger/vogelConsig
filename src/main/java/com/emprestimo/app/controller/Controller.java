package com.emprestimo.app.controller;

import com.emprestimo.app.dto.PessoasDto;
import com.emprestimo.app.processor.PessoasProcessor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@AllArgsConstructor(onConstructor = @__(@Inject))
public class Controller {

    private final PessoasProcessor pessoasProcessor;

    @GetMapping("/v1/Cliente")
    public String getCliente(String nome){
        var dto = PessoasDto.builder().nome(nome).build();
        return pessoasProcessor.getCliente(dto).toString();
    }

    @GetMapping("/v1/ListaCliente")
    public String getListaCliente(){
        return pessoasProcessor.getClienteList().toString();
    }

}
