package com.emprestimo.app.processor;

import com.emprestimo.app.Scripty.PessoaSQL;
import com.emprestimo.app.dto.PessoaDto;
import com.emprestimo.app.model.Pessoa;
import com.emprestimo.app.repository.PessoaRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.EMAIL;

@Named
public class PessoaProcessor {

    private final PessoaRepository pessoaRepository;

    @Inject
    public PessoaProcessor(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa getCliente(PessoaDto cliente){
        return pessoaRepository.getCliente(cliente.getNome());
    }

    public Pessoa getCpf(PessoaDto cliente){
        return pessoaRepository.getCpf(cliente.getCpf());
    }

    public PessoaDto getNumBeneficio(PessoaDto pessoaDto){
        var pessoa = pessoaRepository.getNumBeneficio(pessoaDto.getNumbeneficio());
        var pessoadto = PessoaDto.builder().build();
        return pessoadto;
    }

    public List<PessoaDto> getClienteList(){
        List<PessoaDto> pessoas = new ArrayList<>();
        pessoaRepository.getClienteList().stream().forEach(pessoa -> {
            var p =    PessoaDto.builder()
                    .nome(pessoa.getNOME())
                    .cpf(pessoa.getCPF())
                    .numbeneficio(pessoa.getNUMBENEFICIO())
                    .build();
            pessoas.add(p);
     });
        return pessoas;
    }



    public void postClienteNovo(PessoaDto pessoaDto){
        var pessoa = Pessoa.builder()
                .NOME(pessoaDto.getNome())
                .CPF(pessoaDto.getCpf())
                .NUMBENEFICIO(pessoaDto.getNumbeneficio())
                .build();
        pessoaRepository.postClienteNovo(pessoa);
    }

    public Pessoa getCpfDeletar(PessoaDto cliente){
        return pessoaRepository.getCpfDeletar(cliente.getCpf());
    }

    public Pessoa getNumBeneficioDeletar(PessoaDto cliente){
        return pessoaRepository.getNumBeneficioDeletar(cliente.getNumbeneficio());
    }

    public Pessoa getCpfAtualizar(PessoaDto cliente){
        return pessoaRepository.getCpfAtualizar(cliente.getCpf());
    }

}
