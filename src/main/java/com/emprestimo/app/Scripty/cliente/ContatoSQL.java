package com.emprestimo.app.Scripty.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContatoSQL {

        SQL_GET_LIST_CONTATO ("SELECT * FROM CONTATO WHERE IDPESSOA = ?"),

        SQL_INSERT_CONTATO("insert into contato" +
                                  " (numero ,tipocontato,descricao,idpessoa)" +
                                  " Values(?,?,?,?)"),

        SQL_UPDATE_CONTATO("UPDATE CONTATO SET " +
                "NUMERO = ?, TIPOCONTATO = ?, DESCRICAO = ? " +
                "WHERE IDCONTATO = ?");


    private String value;
}
