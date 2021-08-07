package com.emprestimo.app.model.options;

import com.emprestimo.app.dto.options.CodigoBeneficioDto;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CodigoBeneficio {

    private Long idcodigo;
    private Long codigo;
    private String especie;
    private String utilizacao;


}
