package com.emprestimo.app.processor;

import com.emprestimo.app.dto.PessoaDto;
import com.emprestimo.app.model.Pessoa;
import com.emprestimo.app.repository.PessoaRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class PessoaProcessor {

    private final PessoaRepository pessoaRepository;

    @Inject
    public PessoaProcessor(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaDto getCliente(PessoaDto pessoaDto){
        var pessoa =  pessoaRepository.getCliente(pessoaDto.getNome());
        var pessoadto = PessoaDto.builder()
                .nome(pessoa.getNOME())
                .cpf(pessoa.getCPF())
                .numbeneficio(pessoa.getNUMBENEFICIO())
                .renda(pessoa.getRENDA())
                .data_nascimento(pessoa.getDATA_NASCIMENTO())
                .endereco(pessoa.getENDERECO())
                .cep(pessoa.getCEP())
                .uf(pessoa.getUF())
                .cidade(pessoa.getCIDADE())
                .email(pessoa.getEMAIL())
                .celular(pessoa.getCELULAR())
                .telefone(pessoa.getTELEFONE())
                .build();
        return pessoadto;
    }

    public PessoaDto getCpf(PessoaDto pessoaDto){
        var pessoa = pessoaRepository.getCpf(pessoaDto.getCpf());
        var pessoadto = PessoaDto.builder()
                .nome(pessoa.getNOME())
                .cpf(pessoa.getCPF())
                .numbeneficio(pessoa.getNUMBENEFICIO())
                .renda(pessoa.getRENDA())
                .data_nascimento(pessoa.getDATA_NASCIMENTO())
                .endereco(pessoa.getENDERECO())
                .cep(pessoa.getCEP())
                .uf(pessoa.getUF())
                .cidade(pessoa.getCIDADE())
                .email(pessoa.getEMAIL())
                .celular(pessoa.getCELULAR())
                .telefone(pessoa.getTELEFONE())
                .build();
        return pessoadto;
    }

    public PessoaDto getNumBeneficio(PessoaDto pessoaDto){
        var pessoa = pessoaRepository.getNumBeneficio(pessoaDto.getNumbeneficio());
        var pessoadto = PessoaDto.builder()
                .nome(pessoa.getNOME())
                .cpf(pessoa.getCPF())
                .numbeneficio(pessoa.getNUMBENEFICIO())
                .renda(pessoa.getRENDA())
                .data_nascimento(pessoa.getDATA_NASCIMENTO())
                .endereco(pessoa.getENDERECO())
                .cep(pessoa.getCEP())
                .uf(pessoa.getUF())
                .cidade(pessoa.getCIDADE())
                .email(pessoa.getEMAIL())
                .celular(pessoa.getCELULAR())
                .telefone(pessoa.getTELEFONE())
                .build();
        return pessoadto;
    }

    public List<PessoaDto> getClienteList(){
        List<PessoaDto> pessoas = new ArrayList<>();
        pessoaRepository.getClienteList().stream().forEach(pessoa -> {
            var p =    PessoaDto.builder()
                    .nome(pessoa.getNOME())
                    .cpf(pessoa.getCPF())
                    .numbeneficio(pessoa.getNUMBENEFICIO())
                    .renda(pessoa.getRENDA())
                    .data_nascimento(pessoa.getDATA_NASCIMENTO())
                    .endereco(pessoa.getENDERECO())
                    .cep(pessoa.getCEP())
                    .uf(pessoa.getUF())
                    .cidade(pessoa.getCIDADE())
                    .email(pessoa.getEMAIL())
                    .celular(pessoa.getCELULAR())
                    .telefone(pessoa.getTELEFONE())
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
                .RENDA(pessoaDto.getRenda())
                .DATA_NASCIMENTO(pessoaDto.getData_nascimento())
                .ENDERECO(pessoaDto.getEndereco())
                .CEP(pessoaDto.getCep())
                .UF(pessoaDto.getUf())
                .CIDADE(pessoaDto.getCidade())
                .EMAIL(pessoaDto.getEmail())
                .CELULAR(pessoaDto.getCelular())
                .TELEFONE(pessoaDto.getTelefone())
                .build();
        pessoaRepository.postClienteNovo(pessoa);
    }

    public void getCpfDeletar(PessoaDto pessoaDto){
        var pessoa = Pessoa.builder().CPF(pessoaDto.getCpf()).build();
        pessoaRepository.getCpfDeletar(pessoa);
    }

    public void getNumBeneficioDeletar(PessoaDto pessoaDto){
        var pessoa = Pessoa.builder().NUMBENEFICIO(pessoaDto.getNumbeneficio()).build();
        pessoaRepository.getNumBeneficioDeletar(pessoa);
    }

    public void putCpfAtualizar(PessoaDto pessoaDto){
        var pessoa = Pessoa.builder()
                .NOME(pessoaDto.getNome())
                .CPF(pessoaDto.getCpf())
                .NUMBENEFICIO(pessoaDto.getNumbeneficio())
                .RENDA(pessoaDto.getRenda())
                .DATA_NASCIMENTO(pessoaDto.getData_nascimento())
                .ENDERECO(pessoaDto.getEndereco())
                .CEP(pessoaDto.getCep())
                .UF(pessoaDto.getUf())
                .CIDADE(pessoaDto.getCidade())
                .EMAIL(pessoaDto.getEmail())
                .CELULAR(pessoaDto.getCelular())
                .TELEFONE(pessoaDto.getTelefone())
                .build();
        pessoaRepository.putCpfAtualizar(pessoa);
    }

}
