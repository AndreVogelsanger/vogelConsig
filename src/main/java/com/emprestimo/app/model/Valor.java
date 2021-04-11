package com.emprestimo.app.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Valor {

    private long idvalor;
    private BigDecimal valorliberado;
    private BigDecimal producao;
    private BigDecimal parcela;
    private BigDecimal comissao;
    private BigDecimal percentual;


}
