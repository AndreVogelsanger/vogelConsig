package com.emprestimo.app.Script;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegistroSQL {

        SQL_GET_LIST_REGISTRO ("SELECT * FROM REGISTRO WHERE IDPESSOA = ?"),

        SQL_INSERT_REGISTRO("INSERT INTO REGISTRO" +
                " (NUMBENEFICIO, MATRICULA, IDPESSOA)"+
                " VALUES(?,?,?)"),

        SQL_UPDATE_REGISTRO("UPDATE REGISTRO SET " +
                "NUMBENEFICIO = ?, MATRICULA = ? " +
                "WHERE IDREGISTRO = ?");

        private String value;

}

