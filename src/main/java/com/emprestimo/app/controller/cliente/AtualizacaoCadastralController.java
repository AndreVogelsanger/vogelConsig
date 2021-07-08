package com.emprestimo.app.controller.cliente;

import com.emprestimo.app.dto.cliente.PessoaDto;
import com.emprestimo.app.processor.cliente.PessoaProcessor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;


@RestController
@AllArgsConstructor(onConstructor = @__(@Inject))
public class AtualizacaoCadastralController {


    private final PessoaProcessor pessoaProcessor;

    @PutMapping("/v1/AtualizarPessoaporCpf")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody PessoaDto pessoaDto){
        pessoaProcessor.update(pessoaDto);
    }



}
