package com.emprestimo.app.repository.cliente;


import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.repository.customer.CustomerRowMapperContato;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ContatoRepository {

    private final JdbcTemplate jdbcTemplate;
    private final CustomerRowMapperContato customerRowMapperContato;

    @Inject
    public ContatoRepository(@Named(DataBaseConfig.JDBC_DATABASE) JdbcTemplate jdbcTemplate, CustomerRowMapperContato customerRowMapperContato) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerRowMapperContato = customerRowMapperContato;
    }


}
