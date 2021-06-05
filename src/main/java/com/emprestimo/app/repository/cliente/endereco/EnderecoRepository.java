package com.emprestimo.app.repository.cliente.endereco;

import com.emprestimo.app.Scripty.cliente.EnderecoSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.cliente.Endereco;
import com.emprestimo.app.repository.cliente.rowMappers.RowMapperEndereco;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
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

}
