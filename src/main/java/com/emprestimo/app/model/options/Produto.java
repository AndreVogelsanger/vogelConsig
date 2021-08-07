package com.emprestimo.app.model.options;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Produto {

    private Long idproduto;
    private String produto;

}
