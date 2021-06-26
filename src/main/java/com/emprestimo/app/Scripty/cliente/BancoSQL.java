package com.emprestimo.app.Scripty.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BancoSQL {

    SQL_GET_LIST_BANCO ("SELECT * FROM BANCO WHERE IDPESSOA = ?"),

    SQL_INSERT_BANCO ("INSERT INTO banco"+
                      " (NUMBANCO ,NOMEBANCO,AGENCIA,DIGITOAGENCIA,TIPOCONTA,NUMCONTA,DIGITOCONTA,STATUSCONTA,IDPESSOA)" +
                      " VALUES(?,?,?,?,?,?,?,?,?)");


    //     /*
//    Update
//     */
//
    private String value;


}
