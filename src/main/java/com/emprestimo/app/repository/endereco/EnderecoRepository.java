package com.emprestimo.app.repository.endereco;

import com.emprestimo.app.Script.EnderecoSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.endereco.Endereco;
import com.emprestimo.app.repository.rowMappers.RowMapperEndereco;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.PreparedStatement;
import java.util.List;

@Named
public class EnderecoRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapperEndereco rowMapperEndereco;

    @Inject
    public EnderecoRepository(@Named(DataBaseConfig.JDBC_DATABASE)JdbcTemplate jdbcTemplate, RowMapperEndereco rowMapperEndereco) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapperEndereco = rowMapperEndereco;
    }

    public List<Endereco> GetEnderecoByIdPessoa(Long idpessoa){
        return jdbcTemplate.query(EnderecoSQL.SQL_GET_LIST_ENDERECO.getValue(), rowMapperEndereco,new Object[]{idpessoa});
    }

    @Transactional
    public Endereco updateEndereco(Endereco endereco) {
        jdbcTemplate.update(connection -> {
            PreparedStatement e = connection.prepareStatement(EnderecoSQL.SQL_UPDATE_ENDERECO.getValue());
            e.setString(1, endereco.getLogradouro());
            e.setLong(2, endereco.getNumero());
            e.setString(3, endereco.getTipologradouro());
            e.setString(4, endereco.getCep());
            e.setString(5, endereco.getUf());
            e.setString(6, endereco.getBairro());
            e.setString(7, endereco.getCidade());
            e.setString(8, endereco.getEstado());
            e.setLong(9, endereco.getIdendereco());
            return e;
        });
        return endereco;
    }

}
