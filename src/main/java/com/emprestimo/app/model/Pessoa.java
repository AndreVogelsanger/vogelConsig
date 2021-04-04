package com.emprestimo.app.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
@Builder
public class Pessoa {

  private long IDPESSOA;
  private String NOME;
  private String CPF;
  private String NUMBENEFICIO;
  private BigDecimal RENDA;
  private Date DATA_NASCIMENTO;
  private String ENDERECO;
  private String CEP;
  private String UF;
  private String CIDADE;
  private String EMAIL;
  private String CELULAR;
  private String TELEFONE;

}
