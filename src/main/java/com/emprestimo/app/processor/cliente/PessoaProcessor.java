package com.emprestimo.app.processor.cliente;

import com.emprestimo.app.dto.cliente.PessoaDto;
import com.emprestimo.app.model.cliente.Pessoa;
import com.emprestimo.app.repository.cliente.PessoaRepository;
import lombok.AllArgsConstructor;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@AllArgsConstructor
public class PessoaProcessor {

    private final PessoaRepository pessoaRepository;

//    public List<PessoaDto> findAll(){
//        List<PessoaDto> pessoas = new ArrayList<>();
//        pessoaRepository.findAllPessoa().stream().forEach(pessoa -> {
//            var p = PessoaDto.builder()
//                    .nome(pessoa.getNome())
//                    .cpf(pessoa.getCpf())
//                    .rg(pessoa.getRg())
//                    .dataemissaorg(pessoa.getDataemissaorg())
//                    .ufrg(pessoa.getUfrg())
//                    .renda(pessoa.getRenda())
//                    .datanascimento(pessoa.getDatanascimento())
//                    .naturalidae(pessoa.getNaturalidae())
//                    .estadonascimento(pessoa.getEstadonascimento())
//                    .estadocivil(pessoa.getEstadocivil())
//                    .nomepai(pessoa.getNomepai())
//                    .nomemae(pessoa.getNomemae())
//                    .email(pessoa.getEmail())
//                    .indicacao(pessoa.getIndicacao())
//                    .numbeneficio(pessoa.getNumbeneficio())
//                    .matricula(pessoa.getMatricula())
//                    .build();
//                pessoas.add(p);
//        });
//        return pessoas;
//    }

//    public PessoaDto FindByCpf(PessoaDto pessoaDto){
//        var pessoa = pessoaRepository.findByCpf(pessoaDto.getCpf());
//        var pessoadto = PessoaDto.builder()
//                .nome(pessoa.getNome())
//                .cpf(pessoa.getCpf())
//                .rg(pessoa.getRg())
//                .dataemissaorg(pessoa.getDataemissaorg())
//                .ufrg(pessoa.getUfrg())
//                .renda(pessoa.getRenda())
//                .datanascimento(pessoa.getDatanascimento())
//                .naturalidae(pessoa.getNaturalidae())
//                .estadonascimento(pessoa.getEstadonascimento())
//                .estadocivil(pessoa.getEstadocivil())
//                .nomepai(pessoa.getNomepai())
//                .nomemae(pessoa.getNomemae())
//                .email(pessoa.getEmail())
//                .indicacao(pessoa.getIndicacao())
//                .numbeneficio(pessoa.getNumbeneficio())
//                .matricula(pessoa.getMatricula())
//                .build();
//        return pessoadto;
//    }

//    public PessoaDto FindByNome(PessoaDto pessoaDto){
//        var pessoa = pessoaRepository.findByNome(pessoaDto.getNome());
//        var pessoadto = PessoaDto.builder()
//                .nome(pessoa.getNome())
//                .cpf(pessoa.getCpf())
//                .rg(pessoa.getRg())
//                .dataemissaorg(pessoa.getDataemissaorg())
//                .ufrg(pessoa.getUfrg())
//                .renda(pessoa.getRenda())
//                .datanascimento(pessoa.getDatanascimento())
//                .naturalidae(pessoa.getNaturalidae())
//                .estadonascimento(pessoa.getEstadonascimento())
//                .estadocivil(pessoa.getEstadocivil())
//                .nomepai(pessoa.getNomepai())
//                .nomemae(pessoa.getNomemae())
//                .email(pessoa.getEmail())
//                .indicacao(pessoa.getIndicacao())
//                .numbeneficio(pessoa.getNumbeneficio())
//                .matricula(pessoa.getMatricula())
//                .build();
//        return pessoadto;
//    }

//    public void Save(PessoaDto pessoaDto){
//        var pessoa = Pessoa.builder()
//                .nome(pessoaDto.getNome())
//                .cpf(pessoaDto.getCpf())
//                .rg(pessoaDto.getRg())
//                .dataemissaorg(pessoaDto.getDataemissaorg())
//                .ufrg(pessoaDto.getUfrg())
//                .renda(pessoaDto.getRenda())
//                .datanascimento(pessoaDto.getDatanascimento())
//                .naturalidae(pessoaDto.getNaturalidae())
//                .estadonascimento(pessoaDto.getEstadonascimento())
//                .estadocivil(pessoaDto.getEstadocivil())
//                .nomepai(pessoaDto.getNomepai())
//                .nomemae(pessoaDto.getNomemae())
//                .email(pessoaDto.getEmail())
//                .indicacao(pessoaDto.getIndicacao())
//                .numbeneficio(pessoaDto.getNumbeneficio())
//                .matricula(pessoaDto.getMatricula())
//                .build();
//        pessoaRepository.SavePessoa(pessoa);
//    }

//    public void Delete(PessoaDto pessoaDto){
//        var pessoa = Pessoa.builder().cpf(pessoaDto.getCpf()).build();
//        pessoaRepository.Delete(pessoa);
//    }



//    public void update(PessoaDto pessoaDto){
//        var pessoa = Pessoa.builder()
//                .nome(pessoaDto.getNome())
//                .cpf(pessoaDto.getCpf())
//                .rg(pessoaDto.getRg())
//                .dataemissaorg(pessoaDto.getDataemissaorg())
//                .ufrg(pessoaDto.getUfrg())
//                .renda(pessoaDto.getRenda())
//                .datanascimento(pessoaDto.getDatanascimento())
//                .naturalidae(pessoaDto.getNaturalidae())
//                .estadonascimento(pessoaDto.getEstadonascimento())
//                .estadocivil(pessoaDto.getEstadocivil())
//                .nomepai(pessoaDto.getNomepai())
//                .nomemae(pessoaDto.getNomemae())
//                .email(pessoaDto.getEmail())
//                .indicacao(pessoaDto.getIndicacao())
//                .numbeneficio(pessoaDto.getNumbeneficio())
//                .matricula(pessoaDto.getMatricula())
//                .build();
//        pessoaRepository.updatePessoa(pessoa);
//    }

}
