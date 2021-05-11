package com.emprestimo.app.dto.cliente;

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
    private String numbeneficio;
    private String matricula;
    private List<ContatoDto> contatoDtoList;
}
