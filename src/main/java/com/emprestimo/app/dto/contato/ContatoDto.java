package com.emprestimo.app.dto.contato;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDto {

    private Long idcontato;
    private String numero;
    private String tipocontato;
    private String descricao;


}
