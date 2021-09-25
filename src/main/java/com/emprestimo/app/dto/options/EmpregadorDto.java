package com.emprestimo.app.dto.options;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EmpregadorDto {

    private Long idempregador;
    private String empregador;

}