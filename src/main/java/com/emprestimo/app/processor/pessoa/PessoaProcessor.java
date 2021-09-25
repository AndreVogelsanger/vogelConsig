package com.emprestimo.app.processor.pessoa;

import com.emprestimo.app.dto.dadosbancario.DadosBancarioDto;
import com.emprestimo.app.dto.contato.ContatoDto;
import com.emprestimo.app.dto.endereco.EnderecoDto;
import com.emprestimo.app.dto.pessoa.PessoaDto;
import com.emprestimo.app.dto.registro.RegistroDto;
import com.emprestimo.app.model.dadosbancario.DadosBancario;
import com.emprestimo.app.model.contato.Contato;
import com.emprestimo.app.model.endereco.Endereco;
import com.emprestimo.app.model.pessoa.Pessoa;
import com.emprestimo.app.model.registro.Registro;
import com.emprestimo.app.repository.dadosbancario.DadosBancarioRepository;
import com.emprestimo.app.repository.pessoa.PessoaRepository;
import com.emprestimo.app.repository.contato.ContatoRepository;
import com.emprestimo.app.repository.endereco.EnderecoRepository;
import com.emprestimo.app.repository.registro.RegistroRepository;
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
    private final DadosBancarioRepository dadosBancarioRepository;
    private final RegistroRepository registroRepository;

    public List<PessoaDto> findAll() {
        List<PessoaDto> pessoas = new ArrayList<>();
        pessoaRepository.findAll().forEach(pessoa -> {

            pessoa.setContatos(contatoRepository.getContatoByIdPessoa(pessoa.getIdpessoa()));
            pessoa.setEnderecos(enderecoRepository.GetEnderecoByIdPessoa(pessoa.getIdpessoa()));
            pessoa.setDadosbancario(dadosBancarioRepository.GetBancoByIdPessoa(pessoa.getIdpessoa()));
            pessoa.setRegistros(registroRepository.GetRegistroByIdPessoa(pessoa.getIdpessoa()));

            List<RegistroDto> registros = new ArrayList<>();
            pessoa.getRegistros().forEach(registro -> {
                var reg = RegistroDto.builder()
                        .numbeneficio(registro.getNumbeneficio())
                        .matricula(registro.getMatricula())
                        .build();
                registros.add(reg);
            });

            List<ContatoDto> contatos = new ArrayList<>();
            pessoa.getContatos().forEach(contato -> {
                var ctt = ContatoDto.builder()
                        .numero(contato.getNumero())
                        .tipocontato(contato.getTipocontato())
                        .decricao(contato.getDecricao())
                        .build();
                contatos.add(ctt);
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

            List<DadosBancarioDto> dadosBancarioDto = new ArrayList<>();
            pessoa.getDadosbancario().stream().forEach(b -> {

                var ban = DadosBancarioDto.builder()
                        .numbanco(b.getNumbanco())
                        .nomebanco(b.getNomebanco())
                        .agencia(b.getAgencia())
                        .digitoagencia(b.getDigitoagencia())
                        .tipoconta(b.getTipoconta())
                        .numconta(b.getNumconta())
                        .digitoconta(b.getDigitoconta())
                        .statusconta(b.getStatusconta())
                        .build();
                dadosBancarioDto.add(ban);
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
                    .registros(registros)
                    .contatos(contatos)
                    .enderecos(enderecoDto)
                    .dadosbancario(dadosBancarioDto)
                    .build();
            pessoas.add(p);


        });
        return pessoas;
    }

    public PessoaDto findByCpf(PessoaDto pessoaDto) {

        var pessoa = pessoaRepository.findByCpf(pessoaDto.getCpf());

        pessoa.setContatos(contatoRepository.getContatoByIdPessoa(pessoa.getIdpessoa()));
        pessoa.setEnderecos(enderecoRepository.GetEnderecoByIdPessoa(pessoa.getIdpessoa()));
        pessoa.setDadosbancario(dadosBancarioRepository.GetBancoByIdPessoa(pessoa.getIdpessoa()));
        pessoa.setRegistros(registroRepository.GetRegistroByIdPessoa(pessoa.getIdpessoa()));

        List<RegistroDto> registros = new ArrayList<>();
        pessoa.getRegistros().forEach(registro -> {
            var reg = RegistroDto.builder()
                    .numbeneficio(registro.getNumbeneficio())
                    .matricula(registro.getMatricula())
                    .build();
            registros.add(reg);
        });
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

        List<DadosBancarioDto> dadosBancarioDto = new ArrayList<>();
        pessoa.getDadosbancario().stream().forEach(b -> {

            var ban = DadosBancarioDto.builder()
                    .numbanco(b.getNumbanco())
                    .nomebanco(b.getNomebanco())
                    .agencia(b.getAgencia())
                    .digitoagencia(b.getDigitoagencia())
                    .tipoconta(b.getTipoconta())
                    .numconta(b.getNumconta())
                    .digitoconta(b.getDigitoconta())
                    .statusconta(b.getStatusconta())
                    .build();
            dadosBancarioDto.add(ban);
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
                .registros(registros)
                .contatos(contatosDto)
                .enderecos(enderecoDto)
                .dadosbancario(dadosBancarioDto)
                .build();

        return pessoadto;
    }

    public PessoaDto findByNome(PessoaDto pessoaDto) {
        var pessoa = pessoaRepository.findByNome(pessoaDto.getNome());

        pessoa.setContatos(contatoRepository.getContatoByIdPessoa(pessoa.getIdpessoa()));
        pessoa.setEnderecos(enderecoRepository.GetEnderecoByIdPessoa(pessoa.getIdpessoa()));
        pessoa.setDadosbancario(dadosBancarioRepository.GetBancoByIdPessoa(pessoa.getIdpessoa()));
        pessoa.setRegistros(registroRepository.GetRegistroByIdPessoa(pessoa.getIdpessoa()));

        List<RegistroDto> registros = new ArrayList<>();
        pessoa.getRegistros().forEach(registro -> {
            var reg = RegistroDto.builder()
                    .numbeneficio(registro.getNumbeneficio())
                    .matricula(registro.getMatricula())
                    .build();
            registros.add(reg);
        });

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

        List<DadosBancarioDto> dadosBancarioDto = new ArrayList<>();
        pessoa.getDadosbancario().stream().forEach(b -> {

            var ban = DadosBancarioDto.builder()
                    .numbanco(b.getNumbanco())
                    .nomebanco(b.getNomebanco())
                    .agencia(b.getAgencia())
                    .digitoagencia(b.getDigitoagencia())
                    .tipoconta(b.getTipoconta())
                    .numconta(b.getNumconta())
                    .digitoconta(b.getDigitoconta())
                    .statusconta(b.getStatusconta())
                    .build();
            dadosBancarioDto.add(ban);
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
                .registros(registros)
                .contatos(contatosDto)
                .enderecos(enderecoDto)
                .dadosbancario(dadosBancarioDto)
                .build();
        return pessoadto;
    }

    public void save(PessoaDto pessoaDto) {

        List<Registro> registros = new ArrayList<>();
        pessoaDto.getRegistros().forEach(registro -> {
            var reg = Registro.builder()
                    .numbeneficio(registro.getNumbeneficio())
                    .matricula(registro.getMatricula())
                    .build();
            registros.add(reg);
        });

        List<Contato> contatos = new ArrayList<>();
        pessoaDto.getContatos().forEach(contato -> {
            var ctt = Contato.builder()
                    .numero(contato.getNumero())
                    .tipocontato(contato.getTipocontato())
                    .decricao(contato.getDecricao())
                    .build();
            contatos.add(ctt);
        });

        List<Endereco> end = new ArrayList<>();
        pessoaDto.getEnderecos().forEach(endereco -> {
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

        List<DadosBancario> dadosBancario = new ArrayList<>();
        pessoaDto.getDadosbancario().forEach(b -> {
            var ban = DadosBancario.builder()
                    .numbanco(b.getNumbanco())
                    .nomebanco(b.getNomebanco())
                    .agencia(b.getAgencia())
                    .digitoagencia(b.getDigitoagencia())
                    .tipoconta(b.getTipoconta())
                    .numconta(b.getNumconta())
                    .digitoconta(b.getDigitoconta())
                    .statusconta(b.getStatusconta())
                    .build();
            dadosBancario.add(ban);
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
                .registros(registros)
                .contatos(contatos)
                .enderecos(end)
                .dadosbancario(dadosBancario)
                .build();

          pessoaRepository.save(pessoa);

    }

    public void delete(PessoaDto pessoaDto) {
        var pessoa = Pessoa.builder().cpf(pessoaDto.getCpf()).build();
        pessoaRepository.delete(pessoa.getCpf());
    }


}
