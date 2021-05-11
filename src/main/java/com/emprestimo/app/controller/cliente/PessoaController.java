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
    //private final PessoaRepository pessoaRepository;

//    @Autowired
//    private final ModelMapper modelMapper;


//    private PessoaDto pessoaDto(int pessoa){
//        return modelMapper.map(pessoa,PessoaDto.class);
//    }
//    private PessoaDto pessoaDto(Pessoa pessoa){
//        return modelMapper.map(pessoa,PessoaDto.class);
//    }

    @GetMapping("/v1/Cliente")
    public PessoaDto findByNome(String nome){
//        Pessoa pessoa = pessoaRepository.findByNome(nome);
//        return pessoaDto(pessoa);
        var dto = PessoaDto.builder().nomeCliente(nome).build();
        return pessoaProcessor.findByNome(dto);
    }

    @GetMapping("/v1/Cpf")
    public PessoaDto findBycpf(String cpf){
//        Pessoa pessoa = pessoaRepository.findByCpf(cpf);
//         return pessoaDto(pessoa);
        var dtopessoa = PessoaDto.builder().cpf(cpf).build();
        return pessoaProcessor.findByCpf(dtopessoa);
    }

    @DeleteMapping("/v1/CpfDeletar")
    public void delete(String cpf){
//        int pessoa = pessoaRepository.Delete(cpf);
//        return pessoaDto(pessoa);
        var dto = PessoaDto.builder().cpf(cpf).build();
        pessoaProcessor.delete(dto);
    }

    @GetMapping("/v1/ListaCliente")
 //   public List<PessoaDto> findAll(){
//        return pessoaRepository.findAll().stream().map(this::pessoaDto).collect(Collectors.toList());
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
//       Pessoa pessoa =pessoaRepository.update(p);
//       pessoaDto(pessoa);
       pessoaProcessor.update(pessoaDto);
    }

}
