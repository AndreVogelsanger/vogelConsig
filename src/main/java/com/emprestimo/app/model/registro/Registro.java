package com.emprestimo.app.model.registro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Registro {

    private Long idregistro;
    private Long idpessoa;
    private Long numbeneficio;
    private Long matricula;

}
