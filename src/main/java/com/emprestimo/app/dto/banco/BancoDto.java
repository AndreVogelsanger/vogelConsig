package com.emprestimo.app.dto.banco;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BancoDto {

    private Long idbanco;
    private Integer numbanco;
    private String nomebanco;
    private Long agencia;
    private Integer digitoagencia;
    private String tipoconta;
    private Long numconta;
    private Integer digitoconta;
    private String statusconta;

}
