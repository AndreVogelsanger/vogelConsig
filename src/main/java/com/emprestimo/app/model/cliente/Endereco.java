package com.emprestimo.app.model.cliente;


import lombok.Builder;
import lombok.Data;

import javax.inject.Named;

@Builder
@Data
public class Endereco {

    private long idendereco;
    private String logradouro;
    private String tipologradouro;
    private String cep;
    private String uf;
    private String bairro;
    private String cidade;
    private String estado;
    private Long idpessoa;


}
