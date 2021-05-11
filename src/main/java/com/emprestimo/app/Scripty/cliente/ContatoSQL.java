package com.emprestimo.app.Scripty.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContatoSQL {

        SQL_GET_LIST_CONTATO ("SELECT * FROM CONTATO WHERE IDPESSOA = ?");

//        /*
//    Insert
//     */
//   // SQL_INSERT_CONTATO(),
//
//     /*
//    Update
//     */
//   // SQL_UPDATE_CONTATO();
//
    private String value;
}
