package com.emprestimo.app.model.options;


import com.emprestimo.app.model.pessoa.Pessoa;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Empregador {

    private Long idempregador;
    private String empregador;

    private List<Pessoa> pessoaList;

}
