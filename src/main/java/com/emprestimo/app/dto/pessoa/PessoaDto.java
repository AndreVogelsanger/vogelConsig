package com.emprestimo.app.dto.pessoa;

import com.emprestimo.app.dto.dadosbancario.DadosBancarioDto;
import com.emprestimo.app.dto.contato.ContatoDto;
import com.emprestimo.app.dto.endereco.EnderecoDto;
import com.emprestimo.app.dto.registro.RegistroDto;

import lombok.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {

    private String nome;
    private String cpf;
    private String rg;
    private Date dataemissaorg;
    private String ufrg;
    private BigDecimal renda;
    private Date datanascimento;
    private String naturalidae;
    private String estadonascimento;
    private String estadocivil;
    private String nomepai;
    private String nomemae;
    private String email;
    private String indicacao;

    private List<ContatoDto> contatos;
    private List<EnderecoDto> enderecos;
    private List<DadosBancarioDto> dadosbancario;
    private List<RegistroDto> registros;

}
