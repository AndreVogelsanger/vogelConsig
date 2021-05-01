package com.emprestimo.app.controller.cliente;

import com.emprestimo.app.dto.cliente.PessoaDto;
import com.emprestimo.app.model.cliente.Pessoa;
import com.emprestimo.app.processor.cliente.PessoaProcessor;
import com.emprestimo.app.repository.cliente.PessoaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor(onConstructor = @__(@Inject))
public class PessoaController {

    private final PessoaProcessor pessoaProcessor;
    private final PessoaRepository pessoaRepository;
    @Autowired
    private final ModelMapper modelMapper;

    @GetMapping("/v1/Cliente")
    public PessoaDto FindByNome(String nome){
        var dto = PessoaDto.builder().nome(nome).build();
        return pessoaProcessor.FindByNome(dto);
    }

    @GetMapping("/v1/Cpf")
    public PessoaDto FindBycpf(String cpf){
        var dtopessoa = PessoaDto.builder().cpf(cpf).build();
        return pessoaProcessor.FindByCpf(dtopessoa);
    }

    @GetMapping("/v1/ListaCliente")
    public List<PessoaDto> findAll(){
        return pessoaRepository.findAll().stream().map(this::pessoaDto).collect(Collectors.toList());
    }

    private PessoaDto pessoaDto(Pessoa pessoa){
        return modelMapper.map(pessoa,PessoaDto.class);
    }

//    public List<PessoaDto> findAll(){
//        return pessoaProcessor.findAll();
//    }


    @PostMapping("/v1/ClienteNovo")
    @ResponseStatus(HttpStatus.CREATED)
    public void Save(@RequestBody PessoaDto pessoaDto){
         pessoaProcessor.Save(pessoaDto);
    }

    @DeleteMapping("/v1/CpfDeletar")
    public void Delete(String cpf){
        var dto = PessoaDto.builder().cpf(cpf).build();
        pessoaProcessor.Delete(dto);
    }

    @PutMapping("/v1/CpfAtualizar")
    public void
    update(@RequestBody PessoaDto pessoaDto){
       pessoaProcessor.update(pessoaDto);
    }


}
