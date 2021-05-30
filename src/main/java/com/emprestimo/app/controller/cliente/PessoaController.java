package com.emprestimo.app.controller.cliente;

import com.emprestimo.app.dto.cliente.PessoaDto;
import com.emprestimo.app.processor.cliente.PessoaProcessor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Inject))
public class PessoaController {

    private final PessoaProcessor pessoaProcessor;

    @GetMapping("/v1/Cliente")
    public PessoaDto findByNome(String nomeCliente){
        var dto = PessoaDto.builder().nomeCliente(nomeCliente).build();
        return pessoaProcessor.findByNome(dto);
    }

    @GetMapping("/v1/Cpf")
    public PessoaDto findBycpf(String cpf){
        var dtopessoa = PessoaDto.builder().cpf(cpf).build();
        return pessoaProcessor.findByCpf(dtopessoa);
    }

    @DeleteMapping("/v1/CpfDeletar")
    public void delete(String cpf){
        var dto = PessoaDto.builder().cpf(cpf).build();
        pessoaProcessor.delete(dto);
    }

    @GetMapping("/v1/ListaCliente")
    public List<PessoaDto> findAll(){
        return pessoaProcessor.findAll();
    }


    @PostMapping("/v1/ClienteNovo")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody PessoaDto pessoaDto){
        pessoaProcessor.save(pessoaDto);
    }


    @PutMapping("/v1/CpfAtualizar")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody PessoaDto pessoaDto){
       pessoaProcessor.update(pessoaDto);
    }

}
