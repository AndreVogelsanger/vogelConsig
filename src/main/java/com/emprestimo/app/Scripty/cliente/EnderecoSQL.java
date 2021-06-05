package com.emprestimo.app.Scripty.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnderecoSQL {

        SQL_GET_LIST_ENDERECO ("SELECT * FROM ENDERECO WHERE IDPESSOA = ?");

//        /*
//    Insert
//     */

        //     /*
//    Update
//     */
//
        private String value;

}

