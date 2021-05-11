package com.emprestimo.app.processor.cliente;

import com.emprestimo.app.dto.cliente.ContatoDto;
import com.emprestimo.app.dto.cliente.PessoaDto;
import com.emprestimo.app.model.cliente.Pessoa;
import com.emprestimo.app.repository.cliente.PessoaRepository;
import com.emprestimo.app.repository.contato.ContatoRepository;
import lombok.AllArgsConstructor;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named
@AllArgsConstructor
public class PessoaProcessor {

    private final PessoaRepository pessoaRepository;
    private final ContatoRepository contatoRepository;

    public List<PessoaDto> findAll(){
        List<PessoaDto> pessoas = new ArrayList<>();
        pessoaRepository.findAll().stream().forEach(pessoa -> {
            var p = PessoaDto.builder()
                    .nomeCliente(pessoa.getNome())
                    .cpf(pessoa.getCpf())
                    .rg(pessoa.getRg())
                    .dataemissaorg(pessoa.getDataemissaorg())
                    .ufrg(pessoa.getUfrg())
                    .renda(pessoa.getRenda())
                    .datanascimento(pessoa.getDatanascimento())
                    .naturalidae(pessoa.getNaturalidae())
                    .estadonascimento(pessoa.getEstadonascimento())
                    .estadocivil(pessoa.getEstadocivil())
                    .nomepai(pessoa.getNomepai())
                    .nomemae(pessoa.getNomemae())
                    .email(pessoa.getEmail())
                    .indicacao(pessoa.getIndicacao())
                    .numbeneficio(pessoa.getNumbeneficio())
                    .matricula(pessoa.getMatricula())
                    .build();
                pessoas.add(p);
        });
        return pessoas;
    }

    public PessoaDto findByCpf(PessoaDto pessoaDto){
        var pessoa = pessoaRepository.findByCpf(pessoaDto.getCpf());
        pessoa.setContatos(contatoRepository.getContatoByIdPessoa(pessoa.getIdpessoa()));

        List<ContatoDto> contatosDto = new ArrayList<>();
        pessoa.getContatos().stream().forEach(contato -> {
            var ctt = ContatoDto.builder()
                    .numero(contato.getNumero())
                    .tipocontato(contato.getTipocontato())
                    .decricao(contato.getDecricao())
                    .build();
              contatosDto.add(ctt);
        });

        // pessoa.getContatos().stream().filter(contato -> contato.getTipocontato().contains("cel")).collect(Collectors.toList());

        var pessoadto = PessoaDto.builder()
                .nomeCliente(pessoa.getNome())
                .cpf(pessoa.getCpf())
                .rg(pessoa.getRg())
                .dataemissaorg(pessoa.getDataemissaorg())
                .ufrg(pessoa.getUfrg())
                .renda(pessoa.getRenda())
                .datanascimento(pessoa.getDatanascimento())
                .naturalidae(pessoa.getNaturalidae())
                .estadonascimento(pessoa.getEstadonascimento())
                .estadocivil(pessoa.getEstadocivil())
                .nomepai(pessoa.getNomepai())
                .nomemae(pessoa.getNomemae())
                .email(pessoa.getEmail())
                .indicacao(pessoa.getIndicacao())
                .numbeneficio(pessoa.getNumbeneficio())
                .matricula(pessoa.getMatricula())
                .contatoDtoList(contatosDto)
                .build();

        return pessoadto;
    }

    public PessoaDto findByNome(PessoaDto pessoaDto){
        var pessoa = pessoaRepository.findByNome(pessoaDto.getNomeCliente());
        var pessoadto = PessoaDto.builder()
                .nomeCliente(pessoa.getNome())
                .cpf(pessoa.getCpf())
                .rg(pessoa.getRg())
                .dataemissaorg(pessoa.getDataemissaorg())
                .ufrg(pessoa.getUfrg())
                .renda(pessoa.getRenda())
                .datanascimento(pessoa.getDatanascimento())
                .naturalidae(pessoa.getNaturalidae())
                .estadonascimento(pessoa.getEstadonascimento())
                .estadocivil(pessoa.getEstadocivil())
                .nomepai(pessoa.getNomepai())
                .nomemae(pessoa.getNomemae())
                .email(pessoa.getEmail())
                .indicacao(pessoa.getIndicacao())
                .numbeneficio(pessoa.getNumbeneficio())
                .matricula(pessoa.getMatricula())
                .build();
        return pessoadto;
    }

    public void save(PessoaDto pessoaDto){
        var pessoa = Pessoa.builder()
                .nome(pessoaDto.getNomeCliente())
                .cpf(pessoaDto.getCpf())
                .rg(pessoaDto.getRg())
                .dataemissaorg(pessoaDto.getDataemissaorg())
                .ufrg(pessoaDto.getUfrg())
                .renda(pessoaDto.getRenda())
                .datanascimento(pessoaDto.getDatanascimento())
                .naturalidae(pessoaDto.getNaturalidae())
                .estadonascimento(pessoaDto.getEstadonascimento())
                .estadocivil(pessoaDto.getEstadocivil())
                .nomepai(pessoaDto.getNomepai())
                .nomemae(pessoaDto.getNomemae())
                .email(pessoaDto.getEmail())
                .indicacao(pessoaDto.getIndicacao())
                .numbeneficio(pessoaDto.getNumbeneficio())
                .matricula(pessoaDto.getMatricula())
                .build();
        pessoaRepository.save(pessoa);
    }

    public void delete(PessoaDto pessoaDto){
        var pessoa = Pessoa.builder().cpf(pessoaDto.getCpf()).build();
        pessoaRepository.delete(pessoa.getCpf());
    }



    public void update(PessoaDto pessoaDto){
        var pessoa = Pessoa.builder()
                .nome(pessoaDto.getNomeCliente())
                .cpf(pessoaDto.getCpf())
                .rg(pessoaDto.getRg())
                .dataemissaorg(pessoaDto.getDataemissaorg())
                .ufrg(pessoaDto.getUfrg())
                .renda(pessoaDto.getRenda())
                .datanascimento(pessoaDto.getDatanascimento())
                .naturalidae(pessoaDto.getNaturalidae())
                .estadonascimento(pessoaDto.getEstadonascimento())
                .estadocivil(pessoaDto.getEstadocivil())
                .nomepai(pessoaDto.getNomepai())
                .nomemae(pessoaDto.getNomemae())
                .email(pessoaDto.getEmail())
                .indicacao(pessoaDto.getIndicacao())
                .numbeneficio(pessoaDto.getNumbeneficio())
                .matricula(pessoaDto.getMatricula())
                .build();
        pessoaRepository.update(pessoa);
    }

}
