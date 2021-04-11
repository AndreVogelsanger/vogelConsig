package com.emprestimo.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValorDto {
    private BigDecimal valorliberado;
    private BigDecimal producao;
    private BigDecimal parcela;
    private BigDecimal comissao;
    private BigDecimal percentual;

}
