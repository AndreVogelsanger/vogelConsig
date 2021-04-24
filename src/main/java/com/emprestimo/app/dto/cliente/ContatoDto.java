package com.emprestimo.app.dto.cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDto {


    private String celular;
    private String telefone;
    private String tipotelefone;


}
