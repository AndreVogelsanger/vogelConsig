package com.emprestimo.app.Scripty.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BancoSQL {

    SQL_GET_LIST_BANCO ("SELECT * FROM BANCO WHERE IDPESSOA = ?");

//        /*
//    Insert
//     */

    //     /*
//    Update
//     */
//
    private String value;


}
