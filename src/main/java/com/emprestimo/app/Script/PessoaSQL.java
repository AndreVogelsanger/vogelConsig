package com.emprestimo.app.Script;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PessoaSQL{

    SQL_GET_NOMEPESSOA ("SELECT * FROM PESSOA WHERE NOME = ?"),

    SQL_GET_CPFPESSOA ("select * from Pessoa WHERE CPF = ?"),

    SQL_GET_LIST_PESSOAS ("SELECT * FROM PESSOA"),

    SQL_GET_IDPESSOA ("select IDPESSOA from Pessoa WHERE CPF = ?"),

    SQL_INSERT_PESSOA("INSERT INTO PESSOA" +
            " (NOME,CPF,RG,DATAEMISSAORG,UFRG,RENDA,DATANASCIMENTO,NATURALIDAE,ESTADONASCIMENTO,ESTADOCIVIL,NOMEPAI,NOMEMAE,EMAIL,INDICACAO)" +
            " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)"),

    SQL_DELETE_CPFPESSOA("DELETE FROM PESSOA WHERE CPF = ?"),

    SQL_UPDATE_PESSOA("UPDATE PESSOA SET NOME = ?" +
            ",CPF = ?,RG = ?,DATAEMISSAORG = ?,UFRG = ?,RENDA = ?" +
            ",DATANASCIMENTO = ?,NATURALIDAE = ?,ESTADONASCIMENTO = ?,ESTADOCIVIL = ?" +
            ",NOMEPAI = ?,NOMEMAE = ?,EMAIL = ?,INDICACAO = ?" +
            " WHERE CPF = ?");

     private String value;
}
