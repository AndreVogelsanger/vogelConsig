package com.emprestimo.app.model.cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contato {

    private long idcontato;
    private String celular;
    private String telefone;
    private String tipotelefone;
    private Pessoa idpessoa;

}
