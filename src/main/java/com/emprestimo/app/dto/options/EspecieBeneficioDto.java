package com.emprestimo.app.dto.options;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
public class EspecieBeneficioDto {

    private Long idespecie;
    private Long codigo;
    private String especie;
    private String utilizacao;

}
