package com.emprestimo.app.dto;

import lombok.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {
    private String nome;
    private String cpf;
    private String numbeneficio;
    private BigDecimal renda;
    private Date data_nascimento;
    private String endereco;
    private String cep;
    private String uf;
    private String cidade;
    private String email;
    private String celular;
    private String telefone;

}
