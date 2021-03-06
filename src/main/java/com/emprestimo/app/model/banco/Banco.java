package com.emprestimo.app.model.banco;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Banco {

    private Long idbanco;
    private Long idpessoa;
    private int numbanco;
    private String nomebanco;
    private long agencia;
    private int digitoagencia;
    private String tipoconta;
    private long numconta;
    private int digitoconta;
    private String statusconta;

}
