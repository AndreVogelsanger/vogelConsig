package com.emprestimo.app.dto.registro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroDto {


    private Long idregistro;
    private Long numbeneficio;
    private Long matricula;

}
