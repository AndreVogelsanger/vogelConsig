package com.emprestimo.app.repository.contato;

import com.emprestimo.app.Script.ContatoSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.contato.Contato;
import com.emprestimo.app.repository.rowMappers.RowMapperContato;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.PreparedStatement;
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

    @Transactional
    public Contato updateContato(Contato contato) {
        jdbcTemplate.update(connection -> {
            PreparedStatement c = connection.prepareStatement(ContatoSQL.SQL_UPDATE_CONTATO.getValue());
            c.setString(1, contato.getNumero());
            c.setString(2, contato.getTipocontato());
            c.setString(3, contato.getDecricao());
            c.setLong(4, contato.getIdcontato());
            return c;
        });
        return contato;
    }


}
