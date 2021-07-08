package com.emprestimo.app.processor.cliente;

import com.emprestimo.app.dto.cliente.BancoDto;
import com.emprestimo.app.dto.cliente.ContatoDto;
import com.emprestimo.app.dto.cliente.EnderecoDto;
import com.emprestimo.app.dto.cliente.PessoaDto;
import com.emprestimo.app.model.cliente.Banco;
import com.emprestimo.app.model.cliente.Contato;
import com.emprestimo.app.model.cliente.Endereco;
import com.emprestimo.app.model.cliente.Pessoa;
import com.emprestimo.app.repository.cliente.banco.BancoRepository;
import com.emprestimo.app.repository.cliente.cliente.PessoaRepository;
import com.emprestimo.app.repository.cliente.contato.ContatoRepository;
import com.emprestimo.app.repository.cliente.endereco.EnderecoRepository;
import lombok.AllArgsConstructor;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@AllArgsConstructor
public class PessoaProcessor {

    private final PessoaRepository pessoaRepository;
    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;
    private final BancoRepository bancoRepository;

    public List<PessoaDto> findAll() {
        List<PessoaDto> pessoas = new ArrayList<>();
        pessoaRepository.findAll().stream().forEach(pessoa -> {

            pessoa.setContatos(contatoRepository.getContatoByIdPessoa(pessoa.getIdpessoa()));
            pessoa.setEnderecos(enderecoRepository.GetEnderecoByIdPessoa(pessoa.getIdpessoa()));
            pessoa.setBancos(bancoRepository.GetBancoByIdPessoa(pessoa.getIdpessoa()));

            List<ContatoDto> contatosDto = new ArrayList<>();
            pessoa.getContatos().stream().forEach(contato -> {
                var ctt = ContatoDto.builder()
                        .numero(contato.getNumero())
                        .tipocontato(contato.getTipocontato())
                        .decricao(contato.getDecricao())
                        .build();
                contatosDto.add(ctt);
            });

            List<EnderecoDto> enderecoDto = new ArrayList<>();
            pessoa.getEnderecos().stream().forEach(endereco -> {
                var end = EnderecoDto.builder()
                        .logradouro(endereco.getLogradouro())
                        .tipologradouro(endereco.getTipologradouro())
                        .numero(endereco.getNumero())
                        .cep(endereco.getCep())
                        .uf(endereco.getUf())
                        .bairro(endereco.getBairro())
                        .cidade(endereco.getCidade())
                        .estado(endereco.getEstado())
                        .build();
                enderecoDto.add(end);
            });

            List<BancoDto> bancoDto = new ArrayList<>();
            pessoa.getBancos().stream().forEach(b -> {

                var ban = BancoDto.builder()
                        .numbanco(b.getNumbanco())
                        .nomebanco(b.getNomebanco())
                        .agencia(b.getAgencia())
                        .digitoagencia(b.getDigitoagencia())
                        .tipoconta(b.getTipoconta())
                        .numconta(b.getNumconta())
                        .digitoconta(b.getDigitoconta())
                        .statusconta(b.getStatusconta())
                        .build();
                bancoDto.add(ban);
            });

            var p = PessoaDto.builder()
                    .nome(pessoa.getNome())
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
                    .contatos(contatosDto)
                    .enderecos(enderecoDto)
                    .bancos(bancoDto)
                    .build();
            pessoas.add(p);


        });
        return pessoas;
    }

    public PessoaDto findByCpf(PessoaDto pessoaDto) {

        var pessoa = pessoaRepository.findByCpf(pessoaDto.getCpf());

        pessoa.setContatos(contatoRepository.getContatoByIdPessoa(pessoa.getIdpessoa()));
        pessoa.setEnderecos(enderecoRepository.GetEnderecoByIdPessoa(pessoa.getIdpessoa()));
        pessoa.setBancos(bancoRepository.GetBancoByIdPessoa(pessoa.getIdpessoa()));

        List<ContatoDto> contatosDto = new ArrayList<>();
        pessoa.getContatos().stream().forEach(contato -> {
            var ctt = ContatoDto.builder()
                    .numero(contato.getNumero())
                    .tipocontato(contato.getTipocontato())
                    .decricao(contato.getDecricao())
                    .build();
            contatosDto.add(ctt);
        });

        List<EnderecoDto> enderecoDto = new ArrayList<>();
        pessoa.getEnderecos().stream().forEach(endereco -> {
            var end = EnderecoDto.builder()
                    .logradouro(endereco.getLogradouro())
                    .tipologradouro(endereco.getTipologradouro())
                    .numero(endereco.getNumero())
                    .cep(endereco.getCep())
                    .uf(endereco.getUf())
                    .bairro(endereco.getBairro())
                    .cidade(endereco.getCidade())
                    .estado(endereco.getEstado())
                    .build();
            enderecoDto.add(end);
        });

        List<BancoDto> bancoDto = new ArrayList<>();
        pessoa.getBancos().stream().forEach(b -> {

            var ban = BancoDto.builder()
                    .numbanco(b.getNumbanco())
                    .nomebanco(b.getNomebanco())
                    .agencia(b.getAgencia())
                    .digitoagencia(b.getDigitoagencia())
                    .tipoconta(b.getTipoconta())
                    .numconta(b.getNumconta())
                    .digitoconta(b.getDigitoconta())
                    .statusconta(b.getStatusconta())
                    .build();
            bancoDto.add(ban);
        });

        var pessoadto = PessoaDto.builder()
                .nome(pessoa.getNome())
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
                .contatos(contatosDto)
                .enderecos(enderecoDto)
                .bancos(bancoDto)
                .build();

        return pessoadto;
    }

    public PessoaDto findByNome(PessoaDto pessoaDto) {
        var pessoa = pessoaRepository.findByNome(pessoaDto.getNome());

        pessoa.setContatos(contatoRepository.getContatoByIdPessoa(pessoa.getIdpessoa()));
        pessoa.setEnderecos(enderecoRepository.GetEnderecoByIdPessoa(pessoa.getIdpessoa()));
        pessoa.setBancos(bancoRepository.GetBancoByIdPessoa(pessoa.getIdpessoa()));

        List<ContatoDto> contatosDto = new ArrayList<>();
        pessoa.getContatos().stream().forEach(contato -> {
            var ctt = ContatoDto.builder()
                    .numero(contato.getNumero())
                    .tipocontato(contato.getTipocontato())
                    .decricao(contato.getDecricao())
                    .build();
            contatosDto.add(ctt);
        });

        List<EnderecoDto> enderecoDto = new ArrayList<>();
        pessoa.getEnderecos().stream().forEach(endereco -> {
            var end = EnderecoDto.builder()
                    .logradouro(endereco.getLogradouro())
                    .tipologradouro(endereco.getTipologradouro())
                    .numero(endereco.getNumero())
                    .cep(endereco.getCep())
                    .uf(endereco.getUf())
                    .bairro(endereco.getBairro())
                    .cidade(endereco.getCidade())
                    .estado(endereco.getEstado())
                    .build();
            enderecoDto.add(end);
        });

        List<BancoDto> bancoDto = new ArrayList<>();
        pessoa.getBancos().stream().forEach(b -> {

            var ban = BancoDto.builder()
                    .numbanco(b.getNumbanco())
                    .nomebanco(b.getNomebanco())
                    .agencia(b.getAgencia())
                    .digitoagencia(b.getDigitoagencia())
                    .tipoconta(b.getTipoconta())
                    .numconta(b.getNumconta())
                    .digitoconta(b.getDigitoconta())
                    .statusconta(b.getStatusconta())
                    .build();
            bancoDto.add(ban);
        });


        var pessoadto = PessoaDto.builder()
                .nome(pessoa.getNome())
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
                .contatos(contatosDto)
                .enderecos(enderecoDto)
                .bancos(bancoDto)
                .build();
        return pessoadto;
    }

    public void save(PessoaDto pessoaDto) {

        List<Contato> contatos = new ArrayList<>();
        pessoaDto.getContatos().stream().forEach(contato -> {
            var ctt = Contato.builder()
                    .numero(contato.getNumero())
                    .tipocontato(contato.getTipocontato())
                    .decricao(contato.getDecricao())
                    .build();
            contatos.add(ctt);
        });

        List<Endereco> end = new ArrayList<>();
        pessoaDto.getEnderecos().stream().forEach(endereco -> {
            var e = Endereco.builder()
                    .logradouro(endereco.getLogradouro())
                    .tipologradouro(endereco.getTipologradouro())
                    .numero(endereco.getNumero())
                    .cep(endereco.getCep())
                    .uf(endereco.getUf())
                    .bairro(endereco.getBairro())
                    .cidade(endereco.getCidade())
                    .estado(endereco.getEstado())
                    .build();
            end.add(e);
        });

        List<Banco> banco = new ArrayList<>();
        pessoaDto.getBancos().stream().forEach(b -> {
            var ban = Banco.builder()
                    .numbanco(b.getNumbanco())
                    .nomebanco(b.getNomebanco())
                    .agencia(b.getAgencia())
                    .digitoagencia(b.getDigitoagencia())
                    .tipoconta(b.getTipoconta())
                    .numconta(b.getNumconta())
                    .digitoconta(b.getDigitoconta())
                    .statusconta(b.getStatusconta())
                    .build();
            banco.add(ban);
        });

        var pessoa = Pessoa.builder()
                .nome(pessoaDto.getNome())
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
                .contatos(contatos)
                .enderecos(end)
                .bancos(banco)
                .build();

          pessoaRepository.save(pessoa);

    }

    public void delete(PessoaDto pessoaDto) {
        var pessoa = Pessoa.builder().cpf(pessoaDto.getCpf()).build();
        pessoaRepository.delete(pessoa.getCpf());
    }


    public void update(PessoaDto pessoaDto) {
        var pessoa = Pessoa.builder()
                .nome(pessoaDto.getNome())
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
