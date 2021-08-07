package com.emprestimo.app.processor.atializacaocadastral;


import com.emprestimo.app.dto.banco.BancoDto;
import com.emprestimo.app.dto.contato.ContatoDto;
import com.emprestimo.app.dto.endereco.EnderecoDto;
import com.emprestimo.app.dto.cliente.PessoaDto;
import com.emprestimo.app.model.banco.Banco;
import com.emprestimo.app.model.contato.Contato;
import com.emprestimo.app.model.endereco.Endereco;
import com.emprestimo.app.model.cliente.Pessoa;
import com.emprestimo.app.repository.banco.BancoRepository;
import com.emprestimo.app.repository.cliente.PessoaRepository;
import com.emprestimo.app.repository.contato.ContatoRepository;
import com.emprestimo.app.repository.endereco.EnderecoRepository;
import lombok.AllArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@AllArgsConstructor
public class AtualizacaoCadastralProcessor {


    private final PessoaRepository pessoaRepository;
    private final BancoRepository bancoRepository;
    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;


    public void updateCliente(PessoaDto pessoaDto) {
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
        pessoaRepository.updateCliente(pessoa);
    }


    public void updateBanco(List<BancoDto> bancoDto) {

        bancoDto.stream().forEach(bancos->{
        var banco = Banco.builder()
                .idbanco(bancos.getIdbanco())
                .numbanco(bancos.getNumbanco())
                .nomebanco(bancos.getNomebanco())
                .agencia(bancos.getAgencia())
                .digitoagencia(bancos.getDigitoagencia())
                .tipoconta(bancos.getTipoconta())
                .numconta(bancos.getNumconta())
                .digitoconta(bancos.getDigitoconta())
                .statusconta(bancos.getStatusconta())
                .build();
        bancoRepository.updateBanco(banco);
        });
    }

    public void updateContato(List<ContatoDto> contatoDto){

        contatoDto.stream().forEach(contatos -> {
            var ctt = Contato.builder()
                    .idcontato(contatos.getIdcontato())
                    .numero(contatos.getNumero())
                    .tipocontato(contatos.getTipocontato())
                    .decricao(contatos.getDecricao())
                    .build();
            contatoRepository.updateContato(ctt);
        });

    }

    public void updateEndereco(List<EnderecoDto> enderecoDto) {

        enderecoDto.stream().forEach(enderecos -> {
            var endereco = Endereco.builder()
                    .idendereco(enderecos.getIdendereco())
                    .logradouro(enderecos.getLogradouro())
                    .numero(enderecos.getNumero())
                    .tipologradouro(enderecos.getTipologradouro())
                    .cep(enderecos.getCep())
                    .uf(enderecos.getUf())
                    .bairro(enderecos.getBairro())
                    .cidade(enderecos.getCidade())
                    .estado(enderecos.getEstado())
                    .build();
            enderecoRepository.updateEndereco(endereco);
        });
    }

}

