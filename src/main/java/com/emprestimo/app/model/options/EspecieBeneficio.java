package com.emprestimo.app.model.options;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EspecieBeneficio {

    private Long idespecie;
    private Long codigo;
    private String especie;
    private String utilizacao;


}
