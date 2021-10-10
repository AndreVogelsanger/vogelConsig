package com.emprestimo.app.processor.atializacaocadastral;


import com.emprestimo.app.dto.dadosbancario.DadosBancarioDto;
import com.emprestimo.app.dto.contato.ContatoDto;
import com.emprestimo.app.dto.endereco.EnderecoDto;
import com.emprestimo.app.dto.options.EmpregadorDto;
import com.emprestimo.app.dto.pessoa.PessoaDto;
import com.emprestimo.app.model.dadosbancario.DadosBancario;
import com.emprestimo.app.model.contato.Contato;
import com.emprestimo.app.model.endereco.Endereco;
import com.emprestimo.app.model.options.Empregador;
import com.emprestimo.app.model.pessoa.Pessoa;
import com.emprestimo.app.repository.dadosbancario.DadosBancarioRepository;
import com.emprestimo.app.repository.options.EmpregadorRepository;
import com.emprestimo.app.repository.pessoa.PessoaRepository;
import com.emprestimo.app.repository.contato.ContatoRepository;
import com.emprestimo.app.repository.endereco.EnderecoRepository;
import lombok.AllArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@AllArgsConstructor
public class AtualizacaoCadastralProcessor {


    private final PessoaRepository pessoaRepository;
    private final DadosBancarioRepository dadosBancarioRepository;
    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;
    private final EmpregadorRepository empregadorRepository;


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
                .build();
        pessoaRepository.updateCliente(pessoa);
    }


    public void updateBanco(List<DadosBancarioDto> dadosBancarioDto) {

        dadosBancarioDto.forEach(bancos->{
        var banco = DadosBancario.builder()
                .iddadosbancario(bancos.getIddadosbancario())
                .numbanco(bancos.getNumbanco())
                .nomebanco(bancos.getNomebanco())
                .agencia(bancos.getAgencia())
                .digitoagencia(bancos.getDigitoagencia())
                .tipoconta(bancos.getTipoconta())
                .numconta(bancos.getNumconta())
                .digitoconta(bancos.getDigitoconta())
                .statusconta(bancos.getStatusconta())
                .build();
        dadosBancarioRepository.updateDadosBancario(banco);
        });
    }

    public void updateContato(List<ContatoDto> contatoDto){

        contatoDto.forEach(contatos -> {
            var ctt = Contato.builder()
                    .idcontato(contatos.getIdcontato())
                    .numero(contatos.getNumero())
                    .tipocontato(contatos.getTipocontato())
                    .descricao(contatos.getDescricao())
                    .build();
            contatoRepository.updateContato(ctt);
        });

    }

    public void updateEndereco(List<EnderecoDto> enderecoDto) {

        enderecoDto.forEach(enderecos -> {
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

    public void updateEmpregador (EmpregadorDto empregadorDto){
        var empregador = Empregador.builder()
                .empregador(empregadorDto.getEmpregador())
                .idempregador(empregadorDto.getIdempregador())
                .build();
        empregadorRepository.updateEmpregador(empregador);
    }

}

