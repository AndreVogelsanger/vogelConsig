package com.emprestimo.app.repository.cliente.contato;

import com.emprestimo.app.Scripty.cliente.ContatoSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.cliente.Contato;
import com.emprestimo.app.repository.cliente.rowMappers.RowMapperContato;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ContatoRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapperContato rowMapperContato;

    @Inject
    public ContatoRepository(@Named(DataBaseConfig.JDBC_DATABASE)JdbcTemplate jdbcTemplate, RowMapperContato rowMapperContato) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapperContato = rowMapperContato;
    }

    public List<Contato> getContatoByIdPessoa(Long idpessoa){
        return jdbcTemplate.query(ContatoSQL.SQL_GET_LIST_CONTATO.getValue(), rowMapperContato,new Object[]{idpessoa});
    }

}
