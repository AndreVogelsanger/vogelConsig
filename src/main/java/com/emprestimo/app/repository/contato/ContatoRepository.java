package com.emprestimo.app.repository.contato;

import com.emprestimo.app.Scripty.cliente.ContatoSQL;
import com.emprestimo.app.Scripty.cliente.PessoaSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.cliente.Contato;
import com.emprestimo.app.model.cliente.Pessoa;
import com.emprestimo.app.repository.customer.CustomerRowMapperContato;
import com.emprestimo.app.repository.customer.CustomerRowMapperPessoa;
import jdk.jfr.Name;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ContatoRepository {

    private final JdbcTemplate jdbcTemplate;
    private final CustomerRowMapperContato customerRowMapperContato;

    @Inject
    public ContatoRepository(@Named(DataBaseConfig.JDBC_DATABASE)JdbcTemplate jdbcTemplate, CustomerRowMapperContato customerRowMapperContato) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerRowMapperContato = customerRowMapperContato;
    }

    public List<Contato> getContatoByIdPessoa(Long idpessoa){
        return jdbcTemplate.query(ContatoSQL.SQL_GET_LIST_CONTATO.getValue(), customerRowMapperContato,new Object[]{idpessoa});
    }

}
