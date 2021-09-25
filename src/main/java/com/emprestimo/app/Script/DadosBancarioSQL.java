package com.emprestimo.app.Script;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DadosBancarioSQL {

    SQL_GET_LIST_DADOSBANCARIO ("SELECT * FROM DADOSBANCARIO WHERE IDPESSOA = ?"),
    SQL_GET_ID_DADOSBANCARIO ("SELECT * FROM DADOSBANCARIO WHERE NUMBANCO = ?"),

    SQL_INSERT_DADOSBANCARIO ("INSERT INTO DADOSBANCARIO"+
                      " (NUMBANCO ,NOMEBANCO,AGENCIA,DIGITOAGENCIA,TIPOCONTA,NUMCONTA,DIGITOCONTA,STATUSCONTA,IDPESSOA)" +
                      " VALUES(?,?,?,?,?,?,?,?,?)"),


    SQL_UPDATE_DADOSBANCARIO("UPDATE DADOSBANCARIO SET " +
            "NUMBANCO = ?,NOMEBANCO = ?,AGENCIA = ?,DIGITOAGENCIA = ?, TIPOCONTA = ?," +
            "NUMCONTA = ?,DIGITOCONTA = ?, STATUSCONTA = ? " +
            "WHERE IDDADOSBANCARIO = ?");

    private String value;


}
