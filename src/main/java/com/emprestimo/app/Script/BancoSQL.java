package com.emprestimo.app.Script;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BancoSQL {

    SQL_GET_LIST_BANCO ("SELECT * FROM BANCO WHERE IDPESSOA = ?"),
    SQL_GET_ID_BANCO ("SELECT * FROM BANCO WHERE NUMBANCO = ?"),

    SQL_INSERT_BANCO ("INSERT INTO banco"+
                      " (NUMBANCO ,NOMEBANCO,AGENCIA,DIGITOAGENCIA,TIPOCONTA,NUMCONTA,DIGITOCONTA,STATUSCONTA,IDPESSOA)" +
                      " VALUES(?,?,?,?,?,?,?,?,?)"),


    SQL_UPDATE_BANCO("UPDATE BANCO SET " +
            "NUMBANCO = ?,NOMEBANCO = ?,AGENCIA = ?,DIGITOAGENCIA = ?, TIPOCONTA = ?," +
            "NUMCONTA = ?,DIGITOCONTA = ?, STATUSCONTA = ? " +
            "WHERE IDBANCO = ?");

    private String value;


}
