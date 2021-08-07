package com.emprestimo.app.Script;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnderecoSQL {

        SQL_GET_LIST_ENDERECO ("SELECT * FROM ENDERECO WHERE IDPESSOA = ?"),

        SQL_INSERT_ENDERECO("INSERT INTO ENDERECO" +
                " (LOGRADOURO ,NUMERO,TIPOLOGRADOURO,CEP,UF,BAIRRO,CIDADE,ESTADO,IDPESSOA)"+
                " VALUES(?,?,?,?,?,?,?,?,?)"),

        SQL_UPDATE_ENDERECO("UPDATE ENDERECO SET " +
                "LOGRADOURO = ?, NUMERO = ?, TIPOLOGRADOURO = ?, CEP = ?," +
                " UF = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ? " +
                "WHERE IDENDERECO = ?");

        private String value;

}

