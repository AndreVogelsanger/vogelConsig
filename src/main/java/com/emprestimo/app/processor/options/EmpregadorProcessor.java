package com.emprestimo.app.processor.options;


import com.emprestimo.app.Script.options.EmpregadorSQL;
import com.emprestimo.app.dto.contato.ContatoDto;
import com.emprestimo.app.dto.dadosbancario.DadosBancarioDto;
import com.emprestimo.app.dto.endereco.EnderecoDto;
import com.emprestimo.app.dto.options.EmpregadorDto;
import com.emprestimo.app.dto.pessoa.PessoaDto;
import com.emprestimo.app.dto.registro.RegistroDto;
import com.emprestimo.app.model.options.Empregador;
import com.emprestimo.app.repository.contato.ContatoRepository;
import com.emprestimo.app.repository.dadosbancario.DadosBancarioRepository;
import com.emprestimo.app.repository.endereco.EnderecoRepository;
import com.emprestimo.app.repository.options.EmpregadorRepository;
import com.emprestimo.app.repository.pessoa.PessoaRepository;
import com.emprestimo.app.repository.registro.RegistroRepository;
import lombok.AllArgsConstructor;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@AllArgsConstructor
public class EmpregadorProcessor {

    private final EmpregadorRepository empregadorRepository;
    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;
    private final ContatoRepository contatoRepository;
    private final DadosBancarioRepository dadosBancarioRepository;
    private  final RegistroRepository registroRepository;

    public List<EmpregadorDto> GetAllEmpregador(){

        List<EmpregadorDto> empregadores = new ArrayList<>();
        empregadorRepository.getAllEmpregador().forEach(produto -> {
            var prod = EmpregadorDto.builder()
                    .idempregador(produto.getIdempregador())
                    .empregador(produto.getEmpregador())
                    .build();
            empregadores.add(prod);

        });

        return empregadores;
    }

     public void saveEmpregador(EmpregadorDto empregadorDto){
        var empregador = Empregador.builder()
                .empregador(empregadorDto.getEmpregador())
                .build();
        empregadorRepository.saveEmpregador(empregador);

     }

     public void deleteEmpregador(EmpregadorDto empregadorDto){
        var empregador = Empregador.builder()
                .idempregador(empregadorDto.getIdempregador())
                .build();
        empregadorRepository.deleteEmpregador(empregador.getIdempregador());
     }




    public EmpregadorDto findByIdEmpregador(EmpregadorDto empregadorDto){

        var empregador = empregadorRepository.findByIdEmpregador(empregadorDto.getIdempregador());
        empregadorDto.setEmpregador(empregador.getEmpregador());

        pessoaRepository.findByPessoaPorIdEmpregador(empregadorDto).forEach(p -> {
            var pessoa = PessoaDto.builder()
                    .nome(p.getNome())
                    .cpf(p.getCpf())
                    .rg(p.getRg())
                    .dataemissaorg(p.getDataemissaorg())
                    .ufrg(p.getUfrg())
                    .renda(p.getRenda())
                    .datanascimento(p.getDatanascimento())
                    .naturalidae(p.getNaturalidae())
                    .estadonascimento(p.getEstadonascimento())
                    .estadocivil(p.getEstadocivil())
                    .nomepai(p.getNomepai())
                    .nomemae(p.getNomemae())
                    .email(p.getEmail())
                    .indicacao(p.getIndicacao())
                    .build();

            enderecoRepository.GetEnderecoByIdPessoa(p.getIdpessoa()).forEach(endereco -> {
                var en = EnderecoDto.builder()
                        .logradouro(endereco.getLogradouro())
                        .tipologradouro(endereco.getTipologradouro())
                        .numero(endereco.getNumero())
                        .cep(endereco.getCep())
                        .uf(endereco.getUf())
                        .bairro(endereco.getBairro())
                        .cidade(endereco.getCidade())
                        .estado(endereco.getEstado())
                        .build();
                pessoa.getEnderecos().add(en);
            });

            contatoRepository.getContatoByIdPessoa(p.getIdpessoa()).forEach(contato -> {
                var co = ContatoDto.builder()
                        .descricao(contato.getDescricao())
                        .numero(contato.getNumero())
                        .tipocontato(contato.getTipocontato())
                        .build();
                pessoa.getContatos().add(co);
            });

            dadosBancarioRepository.GetBancoByIdPessoa(p.getIdpessoa()).forEach(dadosBancario -> {
                var dados = DadosBancarioDto.builder()
                        .agencia(dadosBancario.getAgencia())
                        .digitoagencia(dadosBancario.getDigitoagencia())
                        .nomebanco(dadosBancario.getNomebanco())
                        .numbanco(dadosBancario.getNumbanco())
                        .numconta(dadosBancario.getNumconta())
                        .digitoconta(dadosBancario.getDigitoconta())
                        .statusconta(dadosBancario.getStatusconta())
                        .tipoconta(dadosBancario.getTipoconta())
                        .build();
                pessoa.getDadosbancario().add(dados);
            });

            registroRepository.GetRegistroByIdPessoa(p.getIdpessoa()).forEach(registro -> {
                var re = RegistroDto.builder()
                        .numbeneficio(registro.getNumbeneficio())
                        .matricula(registro.getMatricula())
                        .build();
                pessoa.getRegistros().add(re);
            });



            empregadorDto.getPessoaDtoList().add(pessoa);
        });

        return empregadorDto;
    }


}
