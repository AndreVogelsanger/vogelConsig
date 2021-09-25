package com.emprestimo.app.Script.options;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EspecieBeneficioSQL {

    SQL_GETESPECIEBENEFICIO ("SELECT * FROM ESPECIEBENEFICIO");

    private String value;

}
