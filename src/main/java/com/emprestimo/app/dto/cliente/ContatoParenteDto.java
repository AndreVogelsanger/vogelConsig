package com.emprestimo.app.dto.cliente;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContatoParenteDto {


    private String celular;
    private String telefone;
    private String tipotelefone;


}
