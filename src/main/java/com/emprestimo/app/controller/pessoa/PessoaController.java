package com.emprestimo.app.controller.pessoa;

import com.emprestimo.app.dto.options.EmpregadorDto;
import com.emprestimo.app.dto.pessoa.PessoaDto;
import com.emprestimo.app.processor.options.EmpregadorProcessor;
import com.emprestimo.app.processor.pessoa.PessoaProcessor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Inject))
@RequestMapping("/v1/Cliente")
public class PessoaController {

    private final PessoaProcessor pessoaProcessor;

    @GetMapping("BuscaCliente")
    public PessoaDto findByNome(String nomeCliente){
        var dto = PessoaDto.builder().nome(nomeCliente).build();
        return pessoaProcessor.findByNome(dto);
    }

    @GetMapping("BuscaCpf")
    public PessoaDto findBycpf(String cpf){
        var dtopessoa = PessoaDto.builder().cpf(cpf).build();
        return pessoaProcessor.findByCpf(dtopessoa);
    }

    @GetMapping("ListaCliente")
    public List<PessoaDto> findAll(){
        return pessoaProcessor.findAll();
    }
 
    @DeleteMapping("Deletar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(String cpf){
        var dto = PessoaDto.builder().cpf(cpf).build();
        pessoaProcessor.delete(dto);
    }

    @PostMapping("ClienteNovo")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody PessoaDto pessoaDto){
        pessoaProcessor.save(pessoaDto);
    }



}
