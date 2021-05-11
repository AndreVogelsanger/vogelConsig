package com.emprestimo.app.model.cliente;

import com.emprestimo.app.dto.cliente.PessoaDto;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private Long idpessoa;
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
    private String numbeneficio;
    private String matricula;

    private List<Contato> contatos;
    private List<Endereco> Enderecos;
    private List<Banco> Bancos;

}
