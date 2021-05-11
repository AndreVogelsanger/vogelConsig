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

//    SQL_GET_LIST_PESSOAS ("SELECT * FROM PESSOA"),

    SQL_GET_LIST_PESSOAS ("SELECT P.NOME,P.CPF,P.RG,P.DATAEMISSAORG,P.UFRG,P.RENDA,P.DATANASCIMENTO,P.NATURALIDAE," +
            "P.ESTADONASCIMENTO,P.ESTADOCIVIL,P.NOMEPAI,P.NOMEMAE,P.EMAIL,P.INDICACAO,P.NUMBENEFICIO,P.MATRICULA," +
            "C.telefone from Pessoa P inner join contato C on P.idpessoa = C.idpessoa WHERE P.CPF = '12345'"),

//    SQL_GET_LIST_PESSOAS ("SELECT P.NOME,P.CPF,P.RG,P.DATAEMISSAORG,P.UFRG,P.RENDA,P.DATANASCIMENTO,P.NATURALIDAE," +
//            "P.ESTADONASCIMENTO,P.ESTADOCIVIL,P.NOMEPAI,P.NOMEMAE,P.EMAIL,P.INDICACAO,P.NUMBENEFICIO,P.MATRICULA,C.celular," +
//            "C.telefone,C.tipotelefone from Pessoa P inner join contato C on P.idpessoa = C.idpessoa WHERE P.CPF = 12345"),

   // insert into contato (celular,telefone,tipotelefone,idpessoa) Values('123456','123456','celular', (select nextval('sq_pessoa_idpessoa')-1));

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
