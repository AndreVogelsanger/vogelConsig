package com.emprestimo.app.controller;

import com.emprestimo.app.dto.PessoaDto;
import com.emprestimo.app.processor.PessoaProcessor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Date;

import static org.springframework.http.MediaType.*;

@RestController
@AllArgsConstructor(onConstructor = @__(@Inject))
public class Controller {

    private final PessoaProcessor pessoaProcessor;

    @GetMapping("/v1/Cliente")
    public String getCliente(String nome){
        var dto = PessoaDto.builder().nome(nome).build();
        return pessoaProcessor.getCliente(dto).toString();
    }

    @GetMapping("/v1/Cpf")
    public String getCpf(String cpf){
        var dto = PessoaDto.builder().cpf(cpf).build();
        return pessoaProcessor.getCpf(dto).toString();
    }

    @GetMapping("/v1/NumBeneficio")
    public String getNumBeneficio(String numbeneficio){
        var dto = PessoaDto.builder().numbeneficio(numbeneficio).build();
        return pessoaProcessor.getNumBeneficio(dto).toString();
    }

    @GetMapping("/v1/ListaCliente")
    public String getListaCliente(){
        return pessoaProcessor.getClienteList().toString();
    }

    @PostMapping("/v1/ClienteNovo")
    public String PostClienteNovo(String NOME, String CPF, String NUMBENEFICIO, BigDecimal RENDA, Date DATA_NASCIMENTO, String ENDERECO
              , String CEP, String UF, String CIDADE, String EMAIL, String CELULAR, String TELEFONE){
        var dto = PessoaDto.builder()
                .nome(NOME)
                .cpf(CPF)
                .numbeneficio(NUMBENEFICIO)
                .renda(RENDA)
                .data_nascimento(DATA_NASCIMENTO)
                .endereco(ENDERECO)
                .cep(CEP)
                .uf(UF)
                .cidade(CIDADE)
                .email(EMAIL)
                .celular(CELULAR)
                .telefone(TELEFONE)
                .build();
        return pessoaProcessor.postClienteNovo(dto).toString();
    }

    @DeleteMapping("/v1/CpfDeletar")
    public String getCpfDeletar(String cpf){
        var dto = PessoaDto.builder().cpf(cpf).build();
        return pessoaProcessor.getCpfDeletar(dto).toString();
    }

    @DeleteMapping("/v1/NumBeneficioDeletar")
    public String getNumBeneficioDeletar(String numbeneficio){
        var dto = PessoaDto.builder().numbeneficio(numbeneficio).build();
        return pessoaProcessor.getNumBeneficioDeletar(dto).toString();
    }

    @PutMapping("/v1/CpfAtualizar")
    public String getCpfAtualizar(String cpf){
        var dto = PessoaDto.builder().cpf(cpf).build();
        return pessoaProcessor.getCpfAtualizar(dto).toString();
    }


}
