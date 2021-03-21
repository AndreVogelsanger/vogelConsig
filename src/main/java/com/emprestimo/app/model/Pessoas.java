package com.emprestimo.app.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Pessoas {

  private long IDCLIENTE;
  private String NOME;
  private String CPF;
  private String DATA_NASCIMENTO;
  private String ENDERECO;
  private String CEP;
  private String UF;
  private String CIDADE;
  private String EMAIL;
  private String CELULAR;
  private String TELEFONE;

}
