package com.emprestimo.app.repository;

import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.Cliente;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ClienteRepository {

    private static final String SQL_GET_CLIENTE = "SELECT id, name, email FROM app.\"Cliente\" Where name = ?";
    private static final String SQL_GET_LIST_CLIENTE = "SELECT * FROM app.\"Cliente\"";

    private final JdbcTemplate jdbcTemplate;

    @Inject
    public ClienteRepository(@Named(DataBaseConfig.JDBC_DATABASE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Cliente getCliente(String nome){
        return jdbcTemplate.queryForObject(SQL_GET_CLIENTE, new Object[]{nome},
                (rs, rowNum) ->
                        Cliente.builder()
                                .id(rs.getInt("id"))
                                .name(rs.getString("name"))
                                .email(rs.getString("email")).build());
    }

    public List<Cliente> getClienteList(){
        return jdbcTemplate.query(SQL_GET_LIST_CLIENTE,
                (rs, rowNum) ->
                        Cliente.builder()
                                .id(rs.getInt("id"))
                                .name(rs.getString("name"))
                                .email(rs.getString("email")).build());
    }

}
