package com.emprestimo.app.Scripty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PessoaSQL{
    /*
     Selects
     */
    SQL_GET_NOMEPESSOA ("SELECT * FROM PESSOA WHERE NOME = ?"),
    // COMO USAR O LIKE SQL_GET_NOMEPESSOA ("SELECT * FROM PESSOA WHERE NOME LIKE '?%'"),
    // Como trazer formato Json
    SQL_GET_CPFPESSOA ("SELECT * FROM PESSOA WHERE CPF = ?"),
    SQL_GET_NBENEFICIOPESSOAS ("SELECT * FROM PESSOA WHERE NUMBENEFICIO = ?"),
    SQL_GET_LIST_PESSOAS ("SELECT * FROM PESSOA"),

    /*
    Insert
     */
    SQL_INSERT_PESSOA("INSERT INTO PESSOA (NOME,CPF,NUMBENEFICIO) VALUES (?,?,?)"),
//"INSERT INTO PESSOA (NOME,CPF,NUMBENEFICIO,RENDA,DATA_NASCIMENTO,ENDERECO,CEP,UF,CIDADE,EMAIL,CELULAR,TELEFONE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)"
    /*
    Delete
     */
    SQL_DELETE_CPFPESSOA("DELETE FROM PESSOA WHERE CPF = ?"),
    SQL_DELETE_NUMBENEFICIOPESSOA("DELETE FROM PESSOA WHERE NUMBENEFICIO = ?"),

    /*
    Update
     */
    SQL_UPDATE_PESSOA("UPDATE PESSOA SET NOME = ?, CPF = ? , NUMBENEFICIO = ?" +
            ",RENDA = ?,DATA_NASCIMENTO = ?,ENDERECO = ?,CEP = ?,UF = ?,CIDADE = ? ,EMAIL = ?," +
            "CELULAR = ?,TELEFONE = ? WHERE CPF = ?");

     private String value;
}
