package com.emprestimo.app.Scripty.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PessoaSQL{
    /*
    Selects
    */
    SQL_GET_NOMEPESSOA ("SELECT * FROM PESSOA WHERE NOME = ?"),

    SQL_GET_CPFPESSOA ("select * from Pessoa WHERE CPF = ?"),

    SQL_GET_LIST_PESSOAS ("SELECT * FROM PESSOA"),

    /*
    Insert
     */
    SQL_INSERT_PESSOA("INSERT INTO PESSOA" +
            " (NOME,CPF,RG,DATAEMISSAORG,UFRG,RENDA,DATANASCIMENTO,NATURALIDAE,ESTADONASCIMENTO,ESTADOCIVIL,NOMEPAI,NOMEMAE,EMAIL,INDICACAO,NUMBENEFICIO,MATRICULA)" +
            " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"),
    /*
    Delete
     */
    SQL_DELETE_CPFPESSOA("DELETE FROM PESSOA WHERE CPF = ?"),
    /*
    Update
     */
    SQL_UPDATE_PESSOA("UPDATE PESSOA SET NOME = ?" +
            ",CPF = ?,RG = ?,DATAEMISSAORG = ?,UFRG = ?,RENDA = ?" +
            ",DATANASCIMENTO = ?,NATURALIDAE = ?,ESTADONASCIMENTO = ?,ESTADOCIVIL = ?" +
            ",NOMEPAI = ?,NOMEMAE = ?,EMAIL = ?,INDICACAO = ?,NUMBENEFICIO = ?,MATRICULA = ?" +
            " WHERE CPF = ?");

     private String value;
}
