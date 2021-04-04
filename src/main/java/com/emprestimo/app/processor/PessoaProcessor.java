package com.emprestimo.app.processor;

import com.emprestimo.app.Scripty.PessoaSQL;
import com.emprestimo.app.dto.PessoaDto;
import com.emprestimo.app.model.Pessoa;
import com.emprestimo.app.repository.PessoaRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
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

    public Pessoa getNumBeneficio(PessoaDto cliente){
        return pessoaRepository.getNumBeneficio(cliente.getNumbeneficio());
    }

    public List<Pessoa> getClienteList(){
        return pessoaRepository.getClienteList();
    }

    public Pessoa postClienteNovo(PessoaDto cliente){
        return pessoaRepository.postClienteNovo(cliente.getNome(),cliente.getCpf(),cliente.getNumbeneficio(),cliente.getRenda(),
                cliente.getData_nascimento(),cliente.getEndereco(), cliente.getCep(), cliente.getUf(), cliente.getCidade(), cliente.getEmail(),
                cliente.getCelular(), cliente.getTelefone());
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
