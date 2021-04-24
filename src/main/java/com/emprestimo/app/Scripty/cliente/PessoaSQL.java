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
    // COMO USAR O LIKE SQL_GET_NOMEPESSOA ("SELECT NOME FROM PESSOA WHERE NOME LIKE '?%'"),

    SQL_GET_CPFPESSOA ("select P.NOME,P.CPF,P.RG,P.DATAEMISSAORG,P.UFRG,P.RENDA,P.DATANASCIMENTO,P.NATURALIDAE,\n" +
            "P.ESTADONASCIMENTO,P.ESTADOCIVIL,P.NOMEPAI,P.NOMEMAE,P.EMAIL,\n" +
            "P.INDICACAO,P.NUMBENEFICIO,P.MATRICULA,C.celular,C.telefone,C.tipotelefone from Pessoa P \n" +
            "inner join contato C  on p.idpessoa = C.idpessoa  WHERE P.CPF = ?"),

    SQL_GET_LIST_PESSOAS ("SELECT * FROM PESSOA"),
    /*
    Insert
     */
    SQL_INSERT_PESSOA("INSERT INTO PESSOA (NOME,CPF,RG,DATAEMISSAORG,UFRG,RENDA,DATANASCIMENTO,NATURALIDAE,ESTADONASCIMENTO,ESTADOCIVIL,NOMEPAI,NOMEMAE,EMAIL,INDICACAO,NUMBENEFICIO,MATRICULA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"),
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
