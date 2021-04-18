package com.emprestimo.app.dto.cliente;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EnderecoDto {


    private String logradouro;
    private String tipologradouro;
    private String cep;
    private String uf;
    private String bairro;
    private String cidade;
    private String estado;



}
