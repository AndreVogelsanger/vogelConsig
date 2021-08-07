package com.emprestimo.app.dto.options;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProdutoDto {

    private Long idproduto;
    private String produto;

}