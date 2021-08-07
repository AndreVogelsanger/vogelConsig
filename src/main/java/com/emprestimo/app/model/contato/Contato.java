package com.emprestimo.app.model.contato;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contato {

    private Long idcontato;
    private Long idpessoa;
    private String numero;
    private String tipocontato;
    private String decricao;

}
