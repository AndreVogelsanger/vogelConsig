package com.emprestimo.app.model.endereco;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private Long idendereco;
    private Long idpessoa;
    private String logradouro;
    private String tipologradouro;
    private String cep;
    private String uf;
    private String bairro;
    private String cidade;
    private String estado;
    private Long numero;

}
