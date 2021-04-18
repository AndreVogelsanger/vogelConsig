package com.emprestimo.app.model.cliente;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Banco {

    private long idbanco;
    private int numbanco;
    private String nomebanco;
    private long agencia;
    private int digitoagencia;
    private String tipoconta;
    private long numconta;
    private int digitoconta;
    private String statusconta;
    private long idpessoa;

}
