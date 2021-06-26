package com.emprestimo.app.Scripty.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnderecoSQL {

        SQL_GET_LIST_ENDERECO ("SELECT * FROM ENDERECO WHERE IDPESSOA = ?"),

        SQL_INSERT_ENDERECO("INSERT INTO ENDERECO" +
                " (LOGRADOURO ,NUMERO,TIPOLOGRADOURO,CEP,UF,BAIRRO,CIDADE,ESTADO,IDPESSOA)"+
                " VALUES(?,?,?,?,?,?,?,?,?)");

//     /*
//    Update
//     */
//
        private String value;

}

