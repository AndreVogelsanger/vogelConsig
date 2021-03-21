package com.emprestimo.app.controller;

import com.emprestimo.app.dto.ClienteDto;
import com.emprestimo.app.processor.ClienteProcessor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@AllArgsConstructor(onConstructor = @__(@Inject))
public class Controller {

    private final ClienteProcessor clienteProcessor;

    @GetMapping("/v1/Cliente")
    public String getCliente(String nome){
        var dto = ClienteDto.builder().nome(nome).build();
        return clienteProcessor.getCliente(dto).toString();
    }

    @GetMapping("/v1/ListaCliente")
    public String getListaCliente(){
        return clienteProcessor.getClienteList().toString();
    }

}
