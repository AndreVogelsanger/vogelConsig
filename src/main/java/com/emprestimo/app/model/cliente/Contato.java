package com.emprestimo.app.model.cliente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contato {

    private long idcontato;
    private String celular;
    private String telefone;
    private String tipotelefone;
    private long idpessoa;

}
