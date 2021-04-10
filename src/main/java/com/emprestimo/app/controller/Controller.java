package com.emprestimo.app.controller;

import com.emprestimo.app.dto.PessoaDto;
import com.emprestimo.app.model.Pessoa;
import com.emprestimo.app.processor.PessoaProcessor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.springframework.http.MediaType.*;

@RestController
@AllArgsConstructor(onConstructor = @__(@Inject))
public class Controller {

    private final PessoaProcessor pessoaProcessor;

    @GetMapping("/v1/Cliente")
    public PessoaDto getCliente(String nome){
        var dto = PessoaDto.builder().nome(nome).build();
        return pessoaProcessor.getCliente(dto);
    }

    @GetMapping("/v1/Cpf")
    public PessoaDto getCpf(String cpf){
        var dto = PessoaDto.builder().cpf(cpf).build();
        return pessoaProcessor.getCpf(dto);
    }

    @GetMapping("/v1/NumBeneficio")
    public PessoaDto getNumBeneficio(String numbeneficio) {
        var dto = PessoaDto.builder().numbeneficio(numbeneficio).build();
        return pessoaProcessor.getNumBeneficio(dto);
    }

    @GetMapping("/v1/ListaCliente")
    public List<PessoaDto> getListaCliente(){
        return pessoaProcessor.getClienteList();
    }

    @PostMapping("/v1/ClienteNovo")
    @ResponseStatus(HttpStatus.CREATED)
    public void PostClienteNovo (@RequestBody PessoaDto pessoaDto){
         pessoaProcessor.postClienteNovo(pessoaDto);
    }

    @DeleteMapping("/v1/CpfDeletar")
    public void getCpfDeletar(String cpf){
        var dto = PessoaDto.builder().cpf(cpf).build();
        pessoaProcessor.getCpfDeletar(dto);
    }

    @DeleteMapping("/v1/NumBeneficioDeletar")
    public void getNumBeneficioDeletar(String numbeneficio){
        var dto = PessoaDto.builder().numbeneficio(numbeneficio).build();
        pessoaProcessor.getNumBeneficioDeletar(dto);
    }

    @PutMapping("/v1/CpfAtualizar")
    public void putCpfAtualizar(@RequestBody PessoaDto pessoaDto){
       pessoaProcessor.putCpfAtualizar(pessoaDto);
    }


}
