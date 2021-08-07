package com.emprestimo.app.Script.options;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodigobeneficioSql {

    SQL_GETCODBENEFICIO ("SELECT * FROM CODIGOBENEFICIOS");

    private String value;

}
