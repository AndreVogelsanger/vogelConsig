package com.emprestimo.app.Scripty;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ValorSQL {

    /*
    Select
     */

    SQL_GET_LIST_VALOR ("SELECT * FROM VALOR"),

    /*
    Insert
     */
    SQL_INSERT_VALOR ("INSERT INTO VALOR (VALORLIBERADO,PRODUCAO,PARCELA,COMISSAO,PERCENTUAL) VALUES (?,?,?,?,?)");


    private String value;

}
