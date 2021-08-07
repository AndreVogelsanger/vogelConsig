package com.emprestimo.app.dto.options;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
public class CodigoBeneficioDto {

    private Long idcodigo;
    private Long codigo;
    private String especie;
    private String utilizacao;

}
