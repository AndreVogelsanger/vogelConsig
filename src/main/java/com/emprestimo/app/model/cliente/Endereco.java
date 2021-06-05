package com.emprestimo.app.model.cliente;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Named;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private Long idpessoa;
    private String logradouro;
    private String tipologradouro;
    private String cep;
    private String uf;
    private String bairro;
    private String cidade;
    private String estado;
    private long numero;

}
