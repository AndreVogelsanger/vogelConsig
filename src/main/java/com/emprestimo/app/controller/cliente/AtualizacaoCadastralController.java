package com.emprestimo.app.controller.cliente;

import com.emprestimo.app.dto.cliente.PessoaDto;
import com.emprestimo.app.processor.cliente.PessoaProcessor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;


@RestController
@AllArgsConstructor(onConstructor = @__(@Inject))
@RequestMapping("/v1/Atualizar")
public class AtualizacaoCadastralController {


    private final PessoaProcessor pessoaProcessor;

    @PutMapping("ClientePorCpf")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody PessoaDto pessoaDto){
        pessoaProcessor.update(pessoaDto);
    }



}
