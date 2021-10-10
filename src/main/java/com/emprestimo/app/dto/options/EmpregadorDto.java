package com.emprestimo.app.dto.options;

import com.emprestimo.app.dto.pessoa.PessoaDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EmpregadorDto {

    private Long idempregador;
    private String empregador;

    private List<PessoaDto> pessoaDtoList;

    public List<PessoaDto> getPessoaDtoList() {
        if (this.pessoaDtoList == null) {
            pessoaDtoList = new ArrayList<>();
            return pessoaDtoList;
        }
            return pessoaDtoList;
    }

}