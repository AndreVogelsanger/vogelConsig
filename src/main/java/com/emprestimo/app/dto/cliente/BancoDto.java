package com.emprestimo.app.dto.cliente;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BancoDto {

    private int numbanco;
    private String nomebanco;
    private long agencia;
    private int digitoagencia;
    private String tipoconta;
    private long numconta;
    private int digitoconta;
    private String statusconta;


}
