package com.emprestimo.app.Script.options;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProdutoSQL {

    SQL_GETPRODUTO ("SELECT * FROM PRODUTO");

    public String value;

}
