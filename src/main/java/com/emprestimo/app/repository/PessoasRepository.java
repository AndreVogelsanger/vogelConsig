package com.emprestimo.app.repository;

import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.Pessoas;
import com.emprestimo.app.model.Pessoas;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class PessoasRepository {

    private static final String SQL_GET_PESSOAS = "SELECT * FROM app.\"Pessoas\" Where name = ?";
    private static final String SQL_GET_LIST_PESSOAS = "SELECT * FROM app.\"Pessoas\"";

    private final JdbcTemplate jdbcTemplate;

    @Inject
    public PessoasRepository(@Named(DataBaseConfig.JDBC_DATABASE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Pessoas getCliente(String nome){
        return jdbcTemplate.queryForObject(SQL_GET_PESSOAS, new Object[]{nome},
                (rs, rowNum) ->
                        Pessoas.builder()
                                .IDCLIENTE(rs.getInt("IDCLIENTE"))
                                .NOME(rs.getString("NOME"))
                                .CPF(rs.getString("CPF"))
                                .DATA_NASCIMENTO(rs.getString("DATA_NASCIMENTO"))
                                .ENDERECO(rs.getString("ENDERECO"))
                                .CEP(rs.getString("CEP"))
                                .UF(rs.getString("UF"))
                                .CIDADE(rs.getString("CIDADE"))
                                .EMAIL(rs.getString("EMAIL"))
                                .CELULAR(rs.getString("CELULAR"))
                                .TELEFONE(rs.getString("TELEFONE"))
                                .build());
    }

    public List<Pessoas> getClienteList(){
        return jdbcTemplate.query(SQL_GET_LIST_PESSOAS,
                (rs, rowNum) ->
                        Pessoas.builder()
                                .IDCLIENTE(rs.getInt("IDCLIENTE"))
                                .NOME(rs.getString("NOME"))
                                .CPF(rs.getString("CPF"))
                                .DATA_NASCIMENTO(rs.getString("DATA_NASCIMENTO"))
                                .ENDERECO(rs.getString("ENDERECO"))
                                .CEP(rs.getString("CEP"))
                                .UF(rs.getString("UF"))
                                .CIDADE(rs.getString("CIDADE"))
                                .EMAIL(rs.getString("EMAIL"))
                                .CELULAR(rs.getString("CELULAR"))
                                .TELEFONE(rs.getString("TELEFONE"))
                                .build());
    }

}
